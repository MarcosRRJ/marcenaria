var arrayData = [];

$(document).ready(function(){

  $("#form1").submit(function(event){

    cadastrarData(event);
  });


  // $("#cpf").keydown(function(){
  //     try {
  //         $("#cpf").unmask();
  //     } catch (e) {}
  //
  //     var tamanho = $("#cpf").val().length;
  //
  //     if(tamanho <= 11){
  //         $("#cpf").mask("999.999.999-99");
  //     } else if(tamanho > 11){
  //         $("#cpf").mask("99.999.999/9999-99");
  //     }
  //
  //     // ajustando foco
  //     var elem = this;
  //     setTimeout(function(){
  //         // mudo a posição do seletor
  //         elem.selectionStart = elem.selectionEnd = 10000;
  //     }, 0);
  //     // reaplico o valor para mudar o foco
  //     var currentValue = $(this).val();
  //     $(this).val('');
  //     $(this).val(currentValue);
  // });

  jQuery("#cpf")
        .mask("999.999.999-99")
        .focusout(function (event) {
            var target, phone, element;
            target = (event.currentTarget) ? event.currentTarget : event.srcElement;
            phone = target.value.replace(/\D/g, '');
            element = $(target);
            element.unmask();
            if(phone.length > 10) {
                element.mask("999.999.999-99");
            } else {
                element.mask("999.999.999-99");
            }
        });


  jQuery("#rg")
        .mask("99.999.999-9")
        .focusout(function (event) {
            var target, phone, element;
            target = (event.currentTarget) ? event.currentTarget : event.srcElement;
            phone = target.value.replace(/\D/g, '');
            element = $(target);
            element.unmask();
            if(phone.length > 10) {
                element.mask("99.999.999-9");
            } else {
                element.mask("99.999.999-9");
            }
        });


  jQuery("#tel")
        .mask("(99) 9999-9999")
        .focusout(function (event) {
            var target, phone, element;
            target = (event.currentTarget) ? event.currentTarget : event.srcElement;
            phone = target.value.replace(/\D/g, '');
            element = $(target);
            element.unmask();
            if(phone.length > 10) {
                element.mask("(99) 99999-9999");
            } else {
                element.mask("(99) 9999-9999");
            }
        });

    jQuery("#cel")
          .mask("(99) 9999-99999")
          .focusout(function (event) {
              var target, phone, element;
              target = (event.currentTarget) ? event.currentTarget : event.srcElement;
              phone = target.value.replace(/\D/g, '');
              element = $(target);
              element.unmask();
              if(phone.length > 10) {
                  element.mask("(99) 99999-9999");
              } else {
                  element.mask("(99) 9999-99999");
              }
          });

    jQuery("#dataNasc")
          .mask("99/99/9999")
          .focusout(function (event) {
              var target, phone, element;
              target = (event.currentTarget) ? event.currentTarget : event.srcElement;
              phone = target.value.replace(/\D/g, '');
              element = $(target);
              element.unmask();
              if(phone.length > 10) {
                  element.mask("99/99/9999");
              } else {
                  element.mask("99/99/9999");
              }
          });

    jQuery("#cep")
          .mask("99999-999")
          .focusout(function (event) {
              var target, phone, element;
              target = (event.currentTarget) ? event.currentTarget : event.srcElement;
              phone = target.value.replace(/\D/g, '');
              element = $(target);
              element.unmask();
              if(phone.length > 10) {
                  element.mask("99999-999");
              } else {
                  element.mask("99999-999");
              }
          });

});

  // function listarDatas() {
  //   $.post('listaTodasDatas', {
  //   }).then(datas => {
  //     $("#selectListDataSaida option").remove();
  //     $("#selectListDataEntrada option").remove();
  //     arrayData = datas;
  //     $.each(datas, function (i, data) {
  //
  //         //Faz o append (adiciona) cada um dos itens do array como options do select de id combo1
  //         $("#selectListDataEntrada").append($('<option>', {
  //             //neste caso o value do option vai ser a pripriedade Id (é case sensitive, então cuide da nomenclatura)
  //             value: data.id,
  //             //no text estou usando a propriedade Categoria dos objetos dentro do array categoria (case sensitive também)
  //             text: data.descricao
  //         }));
  //
  //         $("#selectListDataSaida").append($('<option>', {
  //             //neste caso o value do option vai ser a pripriedade Id (é case sensitive, então cuide da nomenclatura)
  //             value: data.id,
  //             //no text estou usando a propriedade Categoria dos objetos dentro do array categoria (case sensitive também)
  //             text: data.descricao
  //         }))
  //     })
  //   });
  // }
  //
  //  function listarRelatorio() {
  //   $('#tableRelatorio td').remove();
  //   $.post('listaTodosRelatorio', {
  //   }).then(datas => {
  //     var trHTML = '';
  //
  //      datas.forEach(function(value, index) {
  //
  //          trHTML += '<tr><td>' + value.data.descricao + '</td><td>' + value.somaEntra + '</td><td>' + value.somaSaida + '</td><td>' + value.balancoMensal + '</td></tr>';
  //      });
  //
  //      $('#tableRelatorio').append(trHTML);
  //
  //     console.log(datas);
  //   });
  // }


    function cadastrarData(event) {

      $.ajax({
    		url : "cliente",
    		type : "POST",
    		data: $("#form1").serialize(),
        dataType: "json",
    		success : function(result) {
    			if (result.success) {
    				$("#myModal").modal({show:true}); //Receber tabela carregada na PesquisaPedidos
    			}else if(result.erro.erroVazio.length > 0) {

            result.erro.erroVazio.forEach(function(value, index) {

              document.getElementById(value).style.display = 'block';
            });
    			} else if(result.erro.erroDeTipo.length > 0) {

            result.erro.erroDeTipo.forEach(function(value, index) {

              if (value == 'cpf') {

                $('#12').text('CPF inválido');
                document.getElementById('12').style.display = 'block';
              }
            });
          }
    		}
    	});


      // $.ajax({
      //   type: "POST",
      //   url: "/cliente",
      //   data:   JSON.stringify(json),
      //   dataType: "json",
      //   success: function(response){
      //       // we have the response
      //       if(response.status == "SUCCESS"){
      //           $('#info').html("Info  has been added to the list successfully.<br>"+
      //           "The  Details are as follws : <br> Name : ");
      //
      //       }else{
      //           $('#info').html("Sorry, there is some thing wrong with the data provided.");
      //       }
      //   },
      //    error: function(e){
      //      alert('Error: ' + e);
      //    }
      // });
    event.preventDefault();
  }
