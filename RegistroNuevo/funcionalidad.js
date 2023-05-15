

const datos = document.querySelector("form");
const error = document.getElementById("error");
const cerrar = document.getElementById("cerrar");

  // deshabilitamos el comportamiento por defecto de submit
    datos.addEventListener("submit", async (event) => {
      event.preventDefault();

    
    
      if (datos.nombre === "" || apellido === "" || correo === "" || correo === "" || contraseña === "" || nacimiento === "" || genero === "" || telefono === "") {
        error.classList.remove("oculto");
      } else {
       
        const datosFormulario = new FormData(datos);
        const payload = Object.fromEntries(datosFormulario.entries());
        fetch('usuarios/registro/guardar', {
            method: 'POST',
            headers:{
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(payload)

        })
        .then(response => response.json())
        .then(data => {
            // Maneja la respuesta del backend
            console.log(data);
            // Aquí puedes mostrar un mensaje de éxito o redirigir a otra página
        })
        .catch(error => {
            // Maneja cualquier error que ocurra durante la solicitud
            console.error('Error:', error.message);
        });
      }
    });
    
    cerrar.addEventListener("click", () => {
      error.classList.add("oculto");
    });
   



 
   // vamos a agregar los valores en un objeto.

