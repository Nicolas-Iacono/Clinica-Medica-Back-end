// agregar odontologo

document.getElementById('odontologoPlus').addEventListener('click', function() {
    let formularioOdontologo = document.querySelector('.agregarOdontologo');

console.log(formularioOdontologo);
    
    // Si el formulario tiene la clase 'visibility', la quitamos; de lo contrario, la añadimos
    formularioOdontologo.classList.toggle('visibility1');

    // Desplazamos el scroll hacia el formulario
    if (!formularioOdontologo.classList.contains('visibility1')) {
        formularioOdontologo.scrollIntoView({ behavior: 'smooth' });
    }
});

// agregar paciente
document.getElementById('pacientePlus').addEventListener('click', function() {
    let formularioPaciente = document.querySelector('.agregarPaciente');

console.log(formularioPaciente);
    
    // Si el formulario tiene la clase 'visibility', la quitamos; de lo contrario, la añadimos
    formularioPaciente.classList.toggle('visibility1');

    // Desplazamos el scroll hacia el formulario
    if (!formularioPaciente.classList.contains('visibility1')) {
        formularioPaciente.scrollIntoView({ behavior: 'smooth' });
    }
});

// agregar turno
document.getElementById('turnoPlus').addEventListener('click', function() {
    let formularioTurno = document.querySelector('.agregarTurno');

console.log(formularioTurno);
    
    // Si el formulario tiene la clase 'visibility', la quitamos; de lo contrario, la añadimos
    formularioTurno.classList.toggle('visibility1');

    // Desplazamos el scroll hacia el formulario
    if (!formularioTurno.classList.contains('visibility1')) {
        formularioTurno.scrollIntoView({ behavior: 'smooth' });
    }
});

//buscar paciente
document.getElementById('buscarPaciente').addEventListener('click', function() {
    let formularioDeBusqueda = document.querySelector('.busquedaPaciente');

console.log(formularioDeBusqueda);
    
    // Si el formulario tiene la clase 'visibility', la quitamos; de lo contrario, la añadimos
    formularioDeBusqueda.classList.toggle('visibility1');

    // Desplazamos el scroll hacia el formulario
    if (!formularioDeBusqueda.classList.contains('visibility1')) {
        formularioDeBusqueda.scrollIntoView({ behavior: 'smooth' });
    }
});

//buscar odontologo
document.getElementById('buscarOdontologo').addEventListener('click', function() {
    let formularioDeBusqueda = document.querySelector('.busquedaOdontologo');

console.log(formularioDeBusqueda);
    
    // Si el formulario tiene la clase 'visibility', la quitamos; de lo contrario, la añadimos
    formularioDeBusqueda.classList.toggle('visibility1');

    // Desplazamos el scroll hacia el formulario
    if (!formularioDeBusqueda.classList.contains('visibility1')) {
        formularioDeBusqueda.scrollIntoView({ behavior: 'smooth' });
    }
});

//animacion mensaje de aclaracion de funcion
document.addEventListener("DOMContentLoaded", function(){
    let elemento = document.querySelectorAll('.tooltipped');
    let instacia = M.Tooltip.init(elemento, {});
    console.log(instacia);
})

