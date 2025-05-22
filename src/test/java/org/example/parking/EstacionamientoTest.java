package org.example.parking;

import org.junit.Test;


import java.time.LocalDateTime;

import static junit.framework.Assert.*;

public class EstacionamientoTest {
    @Test
    public void testRetirarVehiculo() throws Exception {
        //done
        Cliente c = new Cliente("405460", "Nahuel Ubal");
        Vehiculo v = new Vehiculo("KZI980", "Fiat Idea", Vehiculo.Tipo.AUTO);
        Estacionamiento estacionamiento = new Estacionamiento();
        boolean ingreso = estacionamiento.ingresarVehiculo(c.getDni(), c.getNombre(), v);


        Ticket ticket = estacionamiento.retirarVehiculo("KZI980");
        assertTrue(ingreso);
        assertEquals(v, ticket.getVehiculo());
        assertEquals(c.getDni(), ticket.getCliente().getDni());


    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // done
        Cliente c = new Cliente("405460", "Nahuel Ubal");
        Vehiculo v = new Vehiculo("KZI980", "Fiat Idea", Vehiculo.Tipo.AUTO);
        LocalDateTime entrada = LocalDateTime.now().minusMinutes(45);
        LocalDateTime salida = LocalDateTime.now();

        Ticket t = new Ticket(c, v, entrada, salida);

        double tarifa = t.calcularPrecio();
        assertEquals(100.0, tarifa);
    }

    @Test
    public void testCalcularPrecio2() throws Exception {
        Cliente c = new Cliente("405460", "Nahuel Ubal");
        Vehiculo v = new Vehiculo("KZI980", "Fiat Idea", Vehiculo.Tipo.SUV);
        LocalDateTime entrada = LocalDateTime.now().minusMinutes(70);
        LocalDateTime salida = LocalDateTime.now();

        Ticket t = new Ticket(c, v, entrada, salida);

        double tarifa = t.calcularPrecio();

        assertEquals(260.0, tarifa);
    }

    @Test
    public void testCalcularPrecio3() throws Exception {
        Cliente c = new Cliente("405460", "Nahuel Ubal");
        Vehiculo v = new Vehiculo("KZI980", "Fiat Idea", Vehiculo.Tipo.PICKUP);
        LocalDateTime entrada = LocalDateTime.now().minusMinutes(200);
        LocalDateTime salida = LocalDateTime.now();

        Ticket t = new Ticket(c, v, entrada, salida);

        double tarifa = t.calcularPrecio();

        assertEquals(720.0, tarifa);
    }

}