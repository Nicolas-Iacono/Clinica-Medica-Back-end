

//DESPLEGA LISTA ODONTOLOGOS
window.onload = function(){
    
    fetch("/odontologos/listar")
    .then(function(response){
       return response.json(); 
    })
    .then(function(data){
        console.log(data)


        for(let i = 0; i< data.length; i++){
        console.log(data[i])


        let infoOdontologo = "<tr>"+
         "<td>"+data[i].id +"</td>"+
         "<td>"+data[i].nombre +"</td>"+
         "<td>"+data[i].apellido +"</td>" +
         "<td>"+data[i].matricula +"</td>"+
         "</tr>";

            document.querySelector("#tablaInfo").innerHTML += infoOdontologo;
        }
    })


}
