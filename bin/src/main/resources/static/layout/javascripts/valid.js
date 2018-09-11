function formatar(mascara, documento){
    var i = documento.value.length;
    var saida = mascara.substring(0,1);
    var texto = mascara.substring(i)

    var tecla=(window.event)?event.keyCode:e.which;
    if((tecla>47 && tecla<58)){

        if (texto.substring(0,1) != saida){
            documento.value += texto.substring(0,1);
        }

    }
    else{
        if (tecla==8 || tecla==0){

         if (texto.substring(0,1) != saida){
            documento.value += texto.substring(0,1);
         }
     }
    else
        return false;
    }
}