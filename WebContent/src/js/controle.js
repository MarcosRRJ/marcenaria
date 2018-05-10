var arrayData = [];

$(document).ready(function(){

  $("#btn_enviarData").on("click", function(event){
    cadastrarData(event);
  });

  listarDatas();
  listarRelatorio();
});

  function listarDatas() {
    $.post('listaTodasDatas', {
    }).then(datas => {
      $("#selectListDataSaida option").remove();      
      $("#selectListDataEntrada option").remove();      
      arrayData = datas;  
      $.each(datas, function (i, data) {

          //Faz o append (adiciona) cada um dos itens do array como options do select de id combo1
          $("#selectListDataEntrada").append($('<option>', {
              //neste caso o value do option vai ser a pripriedade Id (é case sensitive, então cuide da nomenclatura)
              value: data.id,
              //no text estou usando a propriedade Categoria dos objetos dentro do array categoria (case sensitive também)
              text: data.descricao
          }));

          $("#selectListDataSaida").append($('<option>', {
              //neste caso o value do option vai ser a pripriedade Id (é case sensitive, então cuide da nomenclatura)
              value: data.id,
              //no text estou usando a propriedade Categoria dos objetos dentro do array categoria (case sensitive também)
              text: data.descricao
          }))
      })
    });
  }

   function listarRelatorio() {
    $('#tableRelatorio td').remove();
    $.post('listaTodosRelatorio', {
    }).then(datas => {
      var trHTML = '';

       datas.forEach(function(value, index) {

           trHTML += '<tr><td>' + value.data.descricao + '</td><td>' + value.somaEntra + '</td><td>' + value.somaSaida + '</td><td>' + value.balancoMensal + '</td></tr>';
       });

       $('#tableRelatorio').append(trHTML);

      console.log(datas);
    });
  }

 
    function cadastrarData(event) {

    var datas = $("#formData").val();
   
    if (datas) {


      $.post('inserirData', {
       
        descricao :  datas,

        }).then(datas => {
          //$('#inserirData').hide();
          listarDatas();                   
          $('#inserirData').modal('hide');
        }).catch(erro => {
         
           event.preventDefault();

        });

    }else {
       event.preventDefault();
      
    }
    event.preventDefault();
  }


