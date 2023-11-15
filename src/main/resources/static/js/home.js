let dataCalendario = new Date();
let dataSelecionada = new Date();

$(document).ready(function() {
    createCalendar(dataCalendario);


    $("#next-month").click(function(){
        dataCalendario.setMonth(dataCalendario.getMonth()+1);
        createCalendar(dataCalendario);
    });

    $("#previous-month").click(function(){
        dataCalendario.setMonth(dataCalendario.getMonth()-1);
        createCalendar(dataCalendario);
    });
});

function createCalendar(data){
    data.setHours(0,0,0,0);
    dataSelecionada.setHours(0,0,0,0);

    let dataAtual = new Date();
    dataAtual.setHours(0,0,0,0);

    let dataInicio = new Date(data);
    dataInicio.setDate(1);
    if(dataInicio.getDay() !== 0){
        dataInicio.setDate((dataInicio.getDay() * -1)+1);
    }

    let dataFim = new Date(data.getFullYear(),data.getMonth()+1,0);
    if(dataFim.getDay() !== 6){
        dataFim.setDate(dataFim.getDate() + (6 - dataFim.getDay()));
    }

    const nomeMeses = ["Janeiro","Fevereiro","Março","Abril","Maio","Junho",
                            "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"];

    $("#mes").text(nomeMeses[data.getMonth()]);
    $("#ano").text(dataCalendario.getFullYear());

    $("tbody").text("");
    let linha = 0;
    let count = 0;

    let dataAux = new Date(dataInicio);
    dataAux.setHours(0,0,0,0);
    let classe = "";
    while(dataAux <= dataFim){
        if(count % 7 == 0){
            linha++;
            $('tbody').append('<tr id="linha'+linha+'"></tr>');
        }

        if(dataAux.getMonth() !== data.getMonth()){
            classe = ' class="outro-mes" ';
        }else if(dataAux.getTime() == dataSelecionada.getTime()){
            classe = ' class="dia-ativo" ';
        }else{
            classe = '';
        }

        $("#linha"+linha).append("<td id=\""+dataAux.getTime()+"\" "+classe+">"+dataAux.getDate()+"</td>");

        dataAux.setDate(dataAux.getDate() + 1);
        count++;
    }
    $("#data").text(dataSelecionada.toLocaleDateString());
    ativarClickCalendario();
}

function ativarClickCalendario(){
    $('td').click(function(params) {
        if(!$(this).hasClass("outro-mes")){
            $('.dia-ativo').removeClass('dia-ativo');
            $(this).addClass('dia-ativo');
            dataSelecionada = new Date(parseInt(($(this).attr("id"))));
            $("#data").text(dataSelecionada.toLocaleDateString());
        }
    });
}