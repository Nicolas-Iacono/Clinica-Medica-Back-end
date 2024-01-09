
    const formularioEliminacion = document.getElementById("busOdo");
    const inputIdAEliminar = document.getElementById("apellidoInput2");
    const btnEliminar = document.getElementById("btnEliminar");
    
    let idBuscado = "";

    formularioEliminacion.addEventListener("input", function (e) {
      e.preventDefault();
      idBuscado = inputIdAEliminar.value;
      console.log(idBuscado);

      fetch(`/odontologos/${idBuscado}`)
        .then(function(response){
           return response.json();
        })
        .then(function(data){



            if (data.status === 404 ) {
                // Limpiar la tabla si idBuscado no está definido o está vacío
                document.querySelector("#resultados2").innerHTML = "";
                
            }else{
                console.log(data);
                document.querySelector("#resultados2").innerHTML = "";
                
            
                    console.log(data)
            
            
                    let infoOdontologoId =
                    "<table class='highlight'>" +
                    "<thead>" +
                    "<tr>" +
                    "<td>" + "id" + "</td>" +
                    "<td>" + "nombre" + "</td>" +
                    "<td>" + "apellido" + "</td>" +
                    "<td>" + "matricula" + "</td>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr>" +
                    "<td>" + data.id + "</td>" +
                    "<td>" + data.nombre + "</td>" +
                    "<td>" + data.apellido + "</td>" +
                    "<td>" + data.matricula + "</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
                        document.querySelector("#resultados2").innerHTML += infoOdontologoId;
                    
            
            }
           
        })

    });
    

