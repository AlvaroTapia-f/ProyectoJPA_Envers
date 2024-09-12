package main;

import entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        // Abrir el entity manager factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceApp");

        // Abrir el entity manager
        EntityManager em = emf.createEntityManager();
        System.out.println("En marcha Alvaro");

        try{
            //Iniciamos una transaccion
            em.getTransaction().begin();

            Factura factura1 = Factura.builder().build();

            factura1.setNumero(22);
            factura1.setFecha("06/09/24");

            Domicilio domicilio1 = Domicilio.builder()
                    .nombreCalle("CalleUno").numero(123).build();

            Cliente cliente1 = Cliente.builder()
                            .nombre("Pedro").apellido("Perez").dni(44234678).build();

            cliente1.setDomicilio(domicilio1);
            domicilio1.setCliente(cliente1);

            factura1.setCliente(cliente1);

            Categoria alimentos = Categoria.builder()
                            .denominacion("Alimentos").build();

            Categoria lacteos = Categoria.builder()
                            .denominacion("Lacteos").build();

            Categoria perecedero = Categoria.builder()
                    .denominacion("Perecedero").build();

            Categoria Bebidas = Categoria.builder()
                            .denominacion("Bebidas").build();

            Articulo art1 = Articulo.builder()
                            .cantidad(200).denominacion("Jamón crudo 500gr").precio(20).build();

            Articulo art2 = Articulo.builder()
                            .cantidad(350).denominacion("Leche descremada La Serenisima").precio(15).build();

            art1.setCategorias(Arrays.asList(alimentos, perecedero));
            art2.setCategorias(Arrays.asList(lacteos, perecedero, Bebidas));

            DetalleFactura detalle1 = DetalleFactura.builder().build();

            detalle1.setArticulo(art1);
            detalle1.setCantidad(4);
            detalle1.setSubtotal(80);

            DetalleFactura detalle2 = DetalleFactura.builder().build();

            detalle2.setArticulo(art2);
            detalle2.setCantidad(4);
            detalle2.setSubtotal(60);

            factura1.setDetallefactura(Arrays.asList(detalle1, detalle2));

            factura1.setTotal(140);

            em.persist(factura1);


            em.getTransaction().commit();

            //Realizamos una Actualizacion de la Factura
            em.getTransaction().begin();

            factura1.setNumero(88);

            em.getTransaction().commit();

            System.out.println("Factura Actualizada => " + factura1.getNumero() );

            //Eliminamos la Factura
            em.getTransaction().begin();

            em.remove(factura1);

            em.getTransaction().commit();

            System.out.println("Factura Eliminada => " + factura1.getNumero() );

        }catch (Exception e){
            em.getTransaction().rollback();

        }


        //Cerrar entity manager y entity manager factory
        em.close();
        emf.close();


    }
}
