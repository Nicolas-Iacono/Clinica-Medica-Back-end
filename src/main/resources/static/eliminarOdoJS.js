const formularioEliminacion = document.getElementById("formularioEliminacion");
const inputIdAEliminar = document.getElementById("numeroIdAEliminar");
const btnEliminar = document.getElementById("btnEliminar");

let idAEliminar = "";

formularioEliminacion.addEventListener("input", function (e) {
  e.preventDefault();
  idAEliminar = inputIdAEliminar.value;
  console.log(idAEliminar);
});

btnEliminar.addEventListener('click', function (e) {
  e.preventDefault();

  // Construir la URL de la API dinámicamente dentro de la función del evento clic
  const apiUrlEliminar = `http://localhost:8080/odontologos/eliminar/${idAEliminar}`;

  const user = "sa";
  const password = "sa";
  const credenciales = btoa(`${user}:${password}`);

  fetch(apiUrlEliminar, {
    method: 'DELETE', 
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Basic ${credenciales}`
    }
  })
  .then(response => {
        if(!response.ok){
            throw new Error(`Error en la solicitud: ${response.status} - ${response.statusText}`);
            // console.log('Respuesta del servidor:', response);
            // return response.text();
        }
        return response.text();
    })
    .then(data => {
        console.log('Datos del servidor:', data);
        M.toast({html: 'Odontologo eliminado', classes: 'custom-toast-class'})
      })
       .catch(error => {
        console.error('Error en la solicitud:', error);
        M.toast({ html: 'Odontólogo no encontrado', classes: 'custom-toast-class' });
    });

  })

