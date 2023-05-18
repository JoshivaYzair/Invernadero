const selectElement = document.getElementById("seleccionInvernadero");
fetch("http://localhost:8060/invernadero") // Reemplaza "/api/datos" con la URL de tu endpoint
    .then(response => response.json())
    .then(data => {
        data.forEach(option => {
            const newOption = document.createElement("option");
            let valor = option.invernaderoId;
            newOption.value = option.id; // Reemplaza "value" con el nombre de la propiedad que contiene el valor en tus datos
            newOption.text = option.nombre; // Reemplaza "text" con el nombre de la propiedad que contiene el texto en tus datos
            selectElement.appendChild(newOption);
        });
    });

let selectedValue;

selectElement.addEventListener("change", function () {
    if (selectElement.value != null && selectElement.value != "") {
        selectedValue = selectElement.value;
        console.log("Valor seleccionado:", selectedValue);
        fetchData(selectedValue);
    }
    if (selectElement.value == "") {
        const selectSensor = document.getElementById("seleccionSensor");
        selectSensor.innerHTML = "";
    }
});


function fetchData(value) {
    const selectSensor = document.getElementById("seleccionSensor");
    selectSensor.innerHTML = "";
    const sOption = document.createElement("option");
    sOption.value = "";
    sOption.text = "";
    selectSensor.appendChild(sOption);
    fetch("http://localhost:8060/sensor/invernadero/" + value) // Reemplaza "/api/datos" con la URL de tu endpoint
        .then(response => response.json())
        .then(data => {
            data.forEach(option => {
                const newOption = document.createElement("option");
                newOption.value = option.id; // Reemplaza "value" con el nombre de la propiedad que contiene el valor en tus datos
                newOption.text = option.nombre; // Reemplaza "text" con el nombre de la propiedad que contiene el texto en tus datos
                selectSensor.appendChild(newOption);
            });
        });

    let selectSen;

    selectSensor.addEventListener("change", function () {
        if (selectSensor.value != "") {
            selectSen = selectSensor.value;
            console.log("Valor seleccionado sensor:", selectSen);
            $(document).ready(function () {
                var ultimoElemento = null;
                var ultimaTemperatura = null;
                var ultimaHumedad = null;
                var val1 = null;
                var val2 = null;
                var val3 = null;
                var val4 = null;
                var val5 = null;
                var val6 = null;
                var val7 = null;
                var val8 = null;
                var val9 = null;
                var promTem = null;
                var promHum = null;
                obtenerTemperatura();

                setInterval(function () {
                    obtenerTemperatura();
                }, 1000); // Actualiza la temperatura cada 5 segundos

                function obtenerTemperatura() {
                    if (selectSen != null) {
                        $.ajax({
                            url: 'http://localhost:8060/lectura/sensor/' + selectSen,
                            type: 'GET',
                            dataType: 'json',
                            success: function (data) {
                                if (data != null) {

                                    val1 = data[data.length - 2];
                                    val2 = data[data.length - 3];
                                    val3 = data[data.length - 4];
                                    val4 = data[data.length - 5];
                                    val5 = data[data.length - 6];
                                    val6 = data[data.length - 7];
                                    val7 = data[data.length - 8];
                                    val8 = data[data.length - 9];
                                    val9 = data[data.length - 10];



                                    ultimoElemento = data[data.length - 1];
                                    ultimaTemperatura = ultimoElemento.temperatura;
                                    ultimaHumedad = ultimoElemento.humedad;

                                    promTem = ((val1.temperatura + val2.temperatura + val3.temperatura + val4.temperatura + val5.temperatura + val6.temperatura + val7.temperatura + val8.temperatura + val9.temperatura + ultimoElemento.temperatura) / 10);
                                    promHum = ((val1.humedad + val2.humedad + val3.humedad + val4.humedad + val5.humedad + val6.humedad + val7.humedad + val8.humedad + val9.humedad + ultimoElemento.humedad) / 10);
                                    mostrarTemperatura();
                                } else {
                                    $('#temperatura').text('Temperatura actual: °C');
                                    $('#humedad').text('Humedad actual: %');
                                    $('#Promtemperatura').text('Promedio general de temperatura actual: °C');
                                    $('#Promhumedad').text('Promedio general de humedad actual: %');
                                }
                            },
                            error: function () {
                                console.log('Error al obtener la temperatura');
                            }
                        });
                    }
                }
                function mostrarTemperatura() {
                    if (ultimaTemperatura !== null) {
                        $('#temperatura').text('Temperatura actual: ' + ultimaTemperatura + ' °C');
                        $('#humedad').text('Humedad actual: ' + ultimaHumedad + ' %');
                        $('#Promtemperatura').text('Promedio general de temperatura actual: ' + promTem + ' °C');
                        $('#Promhumedad').text('Promedio general de humedad actual: ' + promHum + ' %');
                    }
                }
            });
        }
        if (selectSensor.value == "") {
            console.log("Valor seleccionado sensor: no hay datos");
            $('#temperatura').text('Temperatura actual: °C');
            $('#humedad').text('Humedad actual: %');
            $('#Promtemperatura').text('Promedio general de temperatura actual: °C');
            $('#Promhumedad').text('Promedio general de humedad actual: %');
        }
    });

}


$(document).ready(function () {
    $("#agregar").submit(function (event) {
        event.preventDefault(); // Evita el envío del formulario por defecto

        var formData = {
            nombre: $("#nombre").val(),
            temperaturaMax: $("#temperaturaMax").val(),
            humedadMax: $("#humedadMax").val(),
            temperaturaMin: $("#temperaturaMin").val(),
            humedadMin: $("#humedadMin").val(),
            invernaderoId: selectedValue
        };

        $.ajax({
            type: "POST",
            url: "http://localhost:8090/notificaciones",
            data: JSON.stringify(formData),
            contentType: "application/json",
            success: function (response) {
                console.log("Solicitud exitosa:", response);
                // Aquí puedes realizar acciones adicionales después de enviar los datos
            },
            error: function (xhr, status, error) {
                console.error("Error en la petición:", error);
                // Aquí puedes manejar el error de acuerdo a tus necesidades
            }
        });
    });
});

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/notificaciones",
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, noti) {
                var row = "<tr>" +
                    "<td>" + (noti.nombre) + "</td>" +
                    "<td>" + (noti.temperaturaMax) + "</td>" +
                    "<td>" + (noti.temperaturaMin) + "</td>" +
                    "<td>" + (noti.humedadMax) + "</td>" +
                    "<td>" + (noti.humedadMin) + "</td>" +
                    "<td></td>" +
                    "<tr>";
                $("#tablaNotificaciones > tbody").append(row);
            });
        },
    });
});