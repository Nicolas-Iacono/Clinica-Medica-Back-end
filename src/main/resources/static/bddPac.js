
    // establezco objetoOdontologo vacio

    let objetoPaciente = {
        nombre: "",
        apellido: "",
        dni: 0,
        fechaIngreso: "",
            domicilio :
            {
                calle:"",
                numero:"",
                localidad:"",
                provincia:""
            }
    };



const estadoErroresOK2 = {
    nombre : false,
    apellido : false,
    dni: false,
    fechaIngreso: false,
        domicilio :
        {
            calle:false,
            numero: false,
            localidad: false,
            provincia: false
        }
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

const apiUrlRegPaciente = "/pacientes/registrar" ;




//generar errores

    function mostrarErrores(){
        estadoErroresOK2.nombre ? errorPacienteNombre.classList.add("visibility") : errorPacienteNombre.classList.remove("visibility");
        estadoErroresOK2.apellido ? errorPacienteApellido.classList.add("visibility") : errorPacienteApellido.classList.remove("visibility");
        estadoErroresOK2.dni ? errorPacienteDni.classList.add("visibility") : errorPacienteDni.classList.remove("visibility");
        estadoErroresOK2.fechaIngreso ? errorPacienteFecha.classList.add("visibility") : errorPacienteFecha.classList.remove("visibility");
        estadoErroresOK2.domicilio.calle ? errorPacienteCalle.classList.add("visibility") : errorPacienteCalle.classList.remove("visibility");
        estadoErroresOK2.domicilio.numero ? errorPacienteNumero.classList.add("visibility") : errorPacienteNumero.classList.remove("visibility");
        estadoErroresOK2.domicilio.localidad ? errorPacienteLocalidad.classList.add("visibility") : errorPacienteLocalidad.classList.remove("visibility");
        estadoErroresOK2.domicilio.provincia ? errorPacienteProvincia.classList.add("visibility") : errorPacienteProvincia.classList.remove("visibility");
    }

    formPaciente.addEventListener('input', function(){
//actualizo el estado de pantalla con los datos
        console.log(objetoPaciente)
        objetoPaciente.nombre = nombrePaciente.value;
        objetoPaciente.apellido =apellidoPaciente.value;
        objetoPaciente.dni = dniPaciente.value;
        objetoPaciente.fechaIngreso = fechaIngresoPaciente.value;
        objetoPaciente.domicilio.calle = domicilioCalle.value;
        objetoPaciente.domicilio.numero = domicilioNumero.value;
        objetoPaciente.domicilio.localidad = domicilioLocalidad.value;
        objetoPaciente.domicilio.provincia = domicilioProvincia.value;

        console.log(objetoPaciente);

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

            estadoErroresOK2.domicilio.calle = validarCalle(objetoPaciente.domicilio.calle);
            if(!estadoErroresOK2.domicilio.calle){
                errorPacienteCalle.textContent = "ingrese la calle";
            }else{
                errorPacienteCalle.textContent ="";
            }

            estadoErroresOK2.domicilio.numero = validarNumero(objetoPaciente.domicilio.numero);
            if(!estadoErroresOK2.domicilio.numero){
                errorPacienteNumero.textContent = "ingrese la altura del domicilio";
            }else{
                errorPacienteNumero.textContent = "";
            }

            estadoErroresOK2.domicilio.localidad = validarLocalidad(objetoPaciente.domicilio.localidad);
            if(!estadoErroresOK2.domicilio.localidad){
                errorPacienteLocalidad.textContent = "ingrese localidad";
            }else{
                errorPacienteLocalidad.textContent = ""
            }

            estadoErroresOK2.domicilio.provincia = validarProvincia(objetoPaciente.domicilio.provincia);
            if(!estadoErroresOK2.domicilio.provincia){
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

        if(calle.length > 2 ){
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


    // let datosPacienteAEnviar = {
    //     nombre : "",
    //     apellido : "",
    //     dni: 0,
    //     fechaIngreso: "",
    //         domicilio:{
    //             calle:"",
    //             numero: 0,
    //             localidad: "",
    //             provincia: ""
    //         }
    // }

    //     datosPacienteAEnviar = {
    //     nombre : objetoPaciente.nombre,
    //     apellido : objetoPaciente.apellido,
    //     dni: objetoPaciente.dni,
    //     fechaIngreso: objetoPaciente.fechaIngreso,
    //         domicilio:{
    //             calle:objetoPaciente.domicilio.calle,
    //             numero: objetoPaciente.domicilio.numero,
    //             localidad: objetoPaciente.domicilio.localidad,
    //             provincia: objetoPaciente.domicilio.provincia
    //         }
    // }

    const user2 = "sa";
    const password2 = "sa";
    const credenciales2 = btoa(`${user2}:${password2}`);

    const apiUrlPac = "http://localhost:8080/pacientes/registrar";
    //escuchar el submit del formulario
    btnPacienteRegistrar.addEventListener('click', function(e){
        e.preventDefault();
    
        console.log("pinchame")
        
    // realizar acciones al enviar el formulario
        if(estadoErroresOK2.nombre && estadoErroresOK2.apellido && estadoErroresOK2.dni && estadoErroresOK2.fechaIngreso && estadoErroresOK2.domicilio.calle && estadoErroresOK2.domicilio.numero && estadoErroresOK2.domicilio.localidad && estadoErroresOK2.domicilio.provincia){
            console.log("validaciones correctas y listas para enviar")
           console.log(objetoPaciente)
           
           fetch(apiUrlPac, {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Basic ${credenciales2}`
                },
                body:JSON.stringify(objetoPaciente)
        
            })
                .then(response => 
                
                    M.toast({html: 'Paciente Registrado', classes: 'custom-toast-class'})
                )
            

            navegarPaginaExito()
        }
    });
    function navegarPaginaExito(){
        localStorage.setItem('userPaciente',JSON.stringify(objetoPaciente))
        }





