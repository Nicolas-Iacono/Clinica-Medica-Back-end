
const formularioDeConsulta = document.getElementById("formBtnYbuscador");
const inputDeConsulta = document.getElementById("idOdontologo1");
// const btnEliminar = document.getElementById("btnEliminar");
console.log(formularioDeConsulta);
console.log(inputDeConsulta);

let errores={
    idConsultaOdo: false
}

let idConsulta = "";

const errorDeBusqueda = document.getElementById("errorDeBusqueda");

function mostrarError(){
    errores.idConsultaOdo ? errorDeBusqueda.classList.add("visibility"):errorDeBusqueda.classList.remove("visibility");

}

let objetoConsultado = {
    odoId:"",
    odoNombre: "",
    odoApellido: "",
    odoMatricula: ""
}

formularioDeConsulta.addEventListener("input", function (e) {
  e.preventDefault();

  console.log(inputDeConsulta)

  idConsulta = inputDeConsulta.value;
  console.log(idConsulta);

  fetch(`/odontologos/${idConsulta}`)
    .then(function(response){

       return response.json();
    })
    .then(function(data){

        
        objetoConsultado = {
            odoId: data.id,
            odoNombre: data.nombre,
            odoApellido: data.apellido,
            odoMatricula: data.matricula
        }

        if (data.status === 404 ) {
            // Limpiar la tabla si idConsulta no está definido o está vacío
            document.querySelector("#resultadoDeConsulta").innerHTML = "";
            
        }else{
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
                "<td>" + objetoConsultado.odoId+ "</td>" +
                "<td id='columnaNombreOdo'>" + objetoConsultado.odoNombre + "</td>" +
                "<td id='columnaApellidoOdo'>" + objetoConsultado.odoApellido + "</td>" +
                "<td>" + objetoConsultado.odoMatricula + "</td>" +
                "</tr>" +
                "</tbody>" +
                "</table>";
                    document.querySelector("#resultadoDeConsulta").innerHTML += infoOdontologoId;
                

                    document.querySelector("#odontologoConsultado").innerHTML = objetoConsultado.odoApellido
            

        }
       
    })

});

let apellidoOdoColumna = document.getElementById("columnaApellidoOdo")
let nombreOdoColumna = document.getElementById("columnaNombreOdo")

let odontologoConsultado = document.getElementById("odontologoConsultado");

const btnSeleccionador1 = document.getElementById("btnSeleccionador1");

console.log(btnSeleccionador1);

btnSeleccionador1.addEventListener("click",function(e){
    e.preventDefault();
    console.log("pincasd")
})