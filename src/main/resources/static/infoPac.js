window.onload = function() {
    fetch("/pacientes/listar")
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            console.log(data);

            for (let i = 0; i < data.length; i++) {
                console.log(data[i]);

                let infoPac = "<tr>" +
                "<td>" + data[i].id + "</td>" +
                "<td>" + data[i].nombre + "</td>" +
                "<td>" + data[i].apellido + "</td>" +
                "<td>" + data[i].dni + "</td>" +
                "<td>" + data[i].fechaIngreso + "</td>" +
                "<td>" + data[i].domicilioSalidaDto.calle + "</td>" +
                "<td>" + data[i].domicilioSalidaDto.numero + "</td>" +
                "<td>" + data[i].domicilioSalidaDto.localidad + "</td>" +
                "<td>" + data[i].domicilioSalidaDto.provincia + "</td>" +
                "<td><button class='btn-actualizar' data-id='" + data[i].id + "'>Actualizar</button></td>" +
              "</tr>" +
              "<tr><div class='campoFormulario2'><div></tr>";

                document.querySelector("#tablaPac").innerHTML += infoPac;
            }

            // Agrega un evento de clic a cada botón "Actualizar"

            const btnActualizarArray = document.querySelectorAll('.btn-actualizar');
            const cuerpoTabla = document.querySelector("#tablaPac")
            console.log(cuerpoTabla)
            btnActualizarArray.forEach(function(btnActualizar) {
                btnActualizar.addEventListener('click', function() {
                    // Obtén el ID del paciente desde el atributo "data-id"
                    const pacienteId = this.getAttribute('data-id');
                    // Llama a una función que muestre el formulario con los campos del paciente correspondiente
                    mostrarFormulario(pacienteId);
                });
            });
        });
}

function mostrarFormulario(pacienteId) {

    // Aquí puedes implementar la lógica para mostrar el formulario con los campos del paciente correspondiente
    cdivonsole.log('Mostrar formulario para el paciente con ID:', pacienteId);

    // Por ejemplo, puedes crear un formulario dinámicamente y agregarlo al DOM
    const formulario = document.createElement('form');
    formulario.classList.add('actualizarOdontologoForm');
    formulario.setAttribute('id', 'formularioOdontologoActualizar');
    formulario.innerHTML = 
        "<div class='cajaGrande'>" +
            "<div class='caposARellenar'>" +
                "<div class='camposHorizontales'>" +
                    "<div class='campoColumn'>" +
                        "<label for='nombre'>nombre</label>" +
                        "<input type='text' placeholder='Actualizar nombre' name='nombre' id='nombreActualizarOd'>" +
                        "<div class='campoDeError'>" +
                            "<ul id='nombreErrores'></ul>" +
                        "</div>" +
                    "</div>" +
                    "<div class='campoColumn'>" +
                        "<label for='apellido'>apellido</label>" +
                        "<input type='text' placeholder='Actualizar apellido' name='apellido' id='apellidoActualizarOd'>" +
                        "<div class='campoDeError'>" +
                            "<ul id='apellidoErrores'></ul>" +
                        "</div>" +
                    "</div>" +
                "</div>" +
                "<div class='campoColumn'>" +
                    "<label for='matricula'>matricula</label>" +
                    "<input type='text' placeholder='Actualizar matricula' name='matricula' id='matriculaActualizarOd'>" +
                    "<div class='campoDeError'>" +
                        "<ul id='matriculaErrores'></ul>" +
                    "</div>" +
                "</div>" +
            "</div>" +
            "<button type='submit' class='btn' id='btnAct'>Actualizar</button>" +
        "</div>";

    // Agrega el formulario al DOM (por ejemplo, a un contenedor específico)
    const contenedorFormulario = document.getElementById('contenedorFormulario');
    contenedorFormulario.innerHTML = ''; // Limpia el contenedor antes de agregar el nuevo formulario
    contenedorFormulario.appendChild(formulario);

}



