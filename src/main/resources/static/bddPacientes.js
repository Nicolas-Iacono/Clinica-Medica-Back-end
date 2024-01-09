
    // establezco objetoOdontologo vacio

    const objetoPaciente = {
        nombre: "",
        apellido: "",
        dni: 0,
        fechaIngreso: "",
        calle:"",
        numero:0,
        localidad:"",
        provincia:""
    };



const estadoErroresOK2 = {
    nombre : false,
    apellido : false,
    dni: false,
    fechaIngreso: false,
    calle:false,
    numero: false,
    localidad: false,
    provincia: false
}

// CAPTURAR NODOS
const nombrePaciente = document.querySelector("#nombrePac");
const apellidoPaciente = document.querySelector("#apellidoPac");
const dniPaciente = document.querySelector("#dni");
const fechaIngresoPaciente = document.querySelector("#fecha");
const domicilioCalle = document.querySelector("#calle");
const domicilioNumero = document.querySelector("#numero");
const domicilioLocalidad = document.querySelector("#localidad");
const domicilioProvincia = document.querySelector("#provincia");
const btnPacienteRegistrar = document.querySelector("#btnRegPac");

const errorPacienteNombre = document.querySelector("#nombreErroresPac");
const errorPacienteApellido = document.querySelector("#apellidoErroresPac");
const errorPacienteDni = document.querySelector("#dniErroresPac");
const errorPacienteFecha = document.querySelector("#fechaErroresPac");
const errorPacienteCalle = document.querySelector("#calleErroresDom");

const errorPacienteLocalidad = document.querySelector("#localidadErroresDom");

const errorPacienteNumero = document.querySelector("#numeroErroresPac");

const errorPacienteProvincia = document.querySelector("#provinciaErroresPac");

const formPaciente = document.querySelector("#formularioPaciente");

const apiUrlRegPaciente = "https://localhost:8080/pacientes/registrar" ;




//generar errores

    function mostrarErrores(){
        estadoErroresOK2.nombre ? errorPacienteNombre.classList.add("visibility") : errorPacienteNombre.classList.remove("visibility");
        estadoErroresOK2.apellido ? errorPacienteApellido.classList.add("visibility") : errorPacienteApellido.classList.remove("visibility");
        estadoErroresOK2.dni ? errorPacienteDni.classList.add("visibility") : errorPacienteDni.classList.remove("visibility");
        estadoErroresOK2.fechaIngreso ? errorPacienteFecha.classList.add("visibility") : errorPacienteFecha.classList.remove("visibility");
        estadoErroresOK2.calle ? errorPacienteCalle.classList.add("visibility") : errorPacienteCalle.classList.remove("visibility");
        estadoErroresOK2.numero ? errorPacienteNumero.classList.add("visibility") : errorPacienteNumero.classList.remove("visibility");
        estadoErroresOK2.localidad ? errorPacienteLocalidad.classList.add("visibility") : errorPacienteLocalidad.classList.remove("visibility");
        estadoErroresOK2.provincia ? errorPacienteProvincia.classList.add("visibility") : errorPacienteProvincia.classList.remove("visibility");
    }

    formPaciente.addEventListener('input', function(){
//actualizo el estado de pantalla con los datos

        objetoPaciente.nombre = nombrePaciente.value;
        objetoPaciente.apellido =apellidoPaciente.value;
        objetoPaciente.dni = dniPaciente.value;
        objetoPaciente.fechaIngreso = fechaIngresoPaciente.value;
        objetoPaciente.calle = domicilioCalle.value;
        objetoPaciente.numero = domicilioNumero.value;
        objetoPaciente.localidad = domicilioLocalidad.value;
        objetoPaciente.provincia = domicilioProvincia.value;
//  actualizar el estado de error segun el estado del usuario
        estadoErroresOK2.nombre = validarNombre(objetoPaciente.nombre);
            if(!estadoErroresOK2.nombre){
                errorPacienteNombre.textContent = "El nombre del paciente debe tener al menos 4 caracteres.";
            }else{
                errorPacienteNombre.textContent = "";
            }

        estadoErroresOK2.apellido = validarApellido(objetoPaciente.apellido);
            if(!estadoErroresOK2.apellido){
                errorPacienteApellido.textContent = "El apellido del paciente debe tener al menos 4 caracteres."
            }else{
                errorPacienteApellido.textContent = "";
            }

        estadoErroresOK2.dni = validarDni(objetoPaciente.dni);
            if(!estadoErroresOK2.dni){
                errorPacienteDni.textContent = "El DNI debe tener 8 caracteres, sin puntos ni comas";
            }else{
                errorPacienteDni.textContent = "";
            }

        estadoErroresOK2.fechaIngreso = validarPatronFecha(objetoPaciente.fechaIngreso);
            if(!estadoErroresOK2.fechaIngreso){
                errorPacienteFecha.textContent = "La fecha debe seguir el siguiente formato yyyy/MM/dd";
            }else{
                errorPacienteFecha.textContent = "";
            }
        estadoErroresOK2.fechaIngreso = validarFechaActual(objetoPaciente.fechaIngreso);
            if(!estadoErroresOK2.fechaIngreso){
                errorPacienteFecha.textContent = "La fecha no puede ser anterior al dia de hoy"
            }else{
                errorPacienteFecha.textContent = "";
            }

            estadoErroresOK2.calle = validarCalle(objetoPaciente.calle);
            if(!estadoErroresOK2.calle){
                errorPacienteCalle.textContent = "ingrese la calle";
            }else{
                errorPacienteCalle.textContent ="";
            }

            estadoErroresOK2.numero = validarNumero(objetoPaciente.numero);
            if(!estadoErroresOK2.numero){
                errorPacienteNumero.textContent = "ingrese la altura del domicilio";
            }else{
                errorPacienteNumero.textContent = "";
            }

            estadoErroresOK2.localidad = validarLocalidad(objetoPaciente.localidad);
            if(!estadoErroresOK2.localidad){
                errorPacienteLocalidad.textContent = "ingrese localidad";
            }else{
                errorPacienteLocalidad.textContent = ""
            }

            estadoErroresOK2.provincia = validarProvincia(objetoPaciente.provincia);
            if(!estadoErroresOK2.provincia){
                errorPacienteProvincia.textContent = "ingrese provincia";
            }else{
                errorPacienteProvincia.textContent = ""
            }

        //muestro errores
        mostrarErrores();
        });

    function validarNombre(nombre){
        let resultado = false;

        if(nombre.length >3 && !nombre.includes('/', '@','.')){
            resultado = true;

        }
        return resultado;
    }

    function validarApellido(apellido){
        let resultado = false;

        if(apellido.length >3 && !apellido.includes('/', '@','.')){
            resultado = true;
        }
        return resultado;
    }

    function validarDni(dni){
        let resultado = false;

        if(dni.length >7 && dni.length <9 && !dni.includes('/', '@','.')){
            resultado = true;
        }
        return resultado;
    }

    function validarPatronFecha(fecha) {
        let resultado = false;
        // Patrón para el formato YYYY-MM-DD
        let patronFecha = /^\d{4}-\d{2}-\d{2}$/;

        // Verificar el formato de la fecha
        if (!patronFecha.test(fecha)) {
            resultado = true;
        }
        return resultado
    }
    function validarFechaActual(fecha){
        let resultado = false;

             // Convertir la cadena de fecha a un objeto Date
            let fechaIngresada = new Date(fecha);

             // Obtener la fecha actual
            let fechaActual = new Date();

             // Comparar las fechas
            if (fechaIngresada >= fechaActual) {
                resultado = true;
            }
            return resultado
    }

    function validarCalle(calle){
        let resultado = false;

        if(calle.length > 1 ){
            resultado = true;
        }
        return resultado;
    }
    function validarNumero(numero){
        let resultado = false;

        if(numero.length > 1 ){
            resultado = true;
        }
        return resultado;
    }
    function validarLocalidad(localidad){
        let resultado = false;

        if(localidad.length > 1 ){
            resultado = true;
        }
        return resultado;
    }

    function validarProvincia(provincia){
        let resultado = false;

        if(provincia.length > 1 ){
            resultado = true;
        }
        return resultado;
    }


    const datosPacienteAEnviar = {
        nombre : objetoPaciente.nombre,
        apellido : objetoPaciente.apellido,
        dni: objetoPaciente.dni,
        fechaIngreso: objetoPaciente.fechaIngreso,
        calle:objetoPaciente.calle,
        numero: objetoPaciente.numero,
        localidad: objetoPaciente.localidad,
        provincia: objetoPaciente.provincia
    }

    const user2 = "sa";
    const password2 = "sa";
    const credenciales2 = btoa(`${user2}:${password2}`);


    //escuchar el submit del formulario
    btnPacienteRegistrar.addEventListener('click', function(e){
        e.preventDefault();

    // realizar acciones al enviar el formulario
        if(estadoErroresOK2.nombre && estadoErroresOK2.apellido && estadoErroresOK2.dni && estadoErroresOK2.fechaIngreso && estadoErroresOK2.calle && estadoErroresOK2.numero && estadoErroresOK2.localidad && estadoErroresOK2.provincia){

            fetch(apiUrlRegPaciente, {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json;charset=utf-8',
                    'Authorization': `Basic ${credenciales2}`
                },
                body:JSON.stringify(datosPacienteAEnviar)
            })
                .then(response => response.json())
                .then(datosRecibidos => {
                })
                M.toast({html: 'Paciente Registrado', classes: 'custom-toast-class'})

               navegarPaginaExito()
        }
    });
    function navegarPaginaExito(){
        localStorage.setItem('userPaciente',JSON.stringify(objetoPaciente))
        }





