package com.mycompany.tiendadeciclismo;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author dnlal
 */
public class DivisionTerritorial {
    private static DivisionTerritorial instancia;
    private List<Division> provincias;
    
    private DivisionTerritorial() {
        provincias = new ArrayList<>();
        inicializarDivisiones();
    }
    
    public static DivisionTerritorial getInstancia() {
        if (instancia == null) {
            instancia = new DivisionTerritorial();
        }
        return instancia;
    }
    
    private void inicializarDivisiones() {
        // San José
        Division sanJose = new Division("San José");

// Cantón Central
        Division central = new Division("Central");
        central.agregarSubdivision(new Division("Carmen"));
        central.agregarSubdivision(new Division("Merced"));
        central.agregarSubdivision(new Division("Hospital"));
        central.agregarSubdivision(new Division("Catedral"));
        central.agregarSubdivision(new Division("Zapote"));
        central.agregarSubdivision(new Division("San Francisco de Dos Ríos"));
        central.agregarSubdivision(new Division("Uruca"));
        central.agregarSubdivision(new Division("Mata Redonda"));
        central.agregarSubdivision(new Division("Pavas"));
        central.agregarSubdivision(new Division("Hatillo"));
        central.agregarSubdivision(new Division("San Sebastián"));

// Cantón Escazú
        Division escazu = new Division("Escazú");
        escazu.agregarSubdivision(new Division("Escazú"));
        escazu.agregarSubdivision(new Division("San Antonio"));
        escazu.agregarSubdivision(new Division("San Rafael"));

// Cantón Desamparados
        Division desamparados = new Division("Desamparados");
        desamparados.agregarSubdivision(new Division("Desamparados"));
        desamparados.agregarSubdivision(new Division("San Miguel"));
        desamparados.agregarSubdivision(new Division("San Juan de Dios"));
        desamparados.agregarSubdivision(new Division("San Rafael Arriba"));
        desamparados.agregarSubdivision(new Division("San Antonio"));
        desamparados.agregarSubdivision(new Division("Frailes"));
        desamparados.agregarSubdivision(new Division("Patarrá"));
        desamparados.agregarSubdivision(new Division("San Cristóbal"));
        desamparados.agregarSubdivision(new Division("Rosario"));
        desamparados.agregarSubdivision(new Division("Damas"));
        desamparados.agregarSubdivision(new Division("San Rafael Abajo"));
        desamparados.agregarSubdivision(new Division("Gravilias"));
        desamparados.agregarSubdivision(new Division("Los Guido"));

// Cantón Puriscal
        Division puriscal = new Division("Puriscal");
        puriscal.agregarSubdivision(new Division("Santiago"));
        puriscal.agregarSubdivision(new Division("Mercedes Sur"));
        puriscal.agregarSubdivision(new Division("Barbacoas"));
        puriscal.agregarSubdivision(new Division("Grifo Alto"));
        puriscal.agregarSubdivision(new Division("San Rafael"));
        puriscal.agregarSubdivision(new Division("Candelarita"));
        puriscal.agregarSubdivision(new Division("Desamparaditos"));
        puriscal.agregarSubdivision(new Division("San Antonio"));
        puriscal.agregarSubdivision(new Division("Chires"));

// Cantón Tarrazú
        Division tarrazu = new Division("Tarrazú");
        tarrazu.agregarSubdivision(new Division("San Marcos"));
        tarrazu.agregarSubdivision(new Division("San Lorenzo"));
        tarrazu.agregarSubdivision(new Division("San Carlos"));

// Cantón Aserrí
        Division aserri = new Division("Aserrí");
        aserri.agregarSubdivision(new Division("Aserrí"));
        aserri.agregarSubdivision(new Division("Tarbaca"));
        aserri.agregarSubdivision(new Division("Vuelta de Jorco"));
        aserri.agregarSubdivision(new Division("San Gabriel"));
        aserri.agregarSubdivision(new Division("Legua"));
        aserri.agregarSubdivision(new Division("Monterrey"));
        aserri.agregarSubdivision(new Division("Salitrillos"));

// Cantón Mora
        Division mora = new Division("Mora");
        mora.agregarSubdivision(new Division("Colón"));
        mora.agregarSubdivision(new Division("Guayabo"));
        mora.agregarSubdivision(new Division("Tabarcia"));
        mora.agregarSubdivision(new Division("Piedras Negras"));
        mora.agregarSubdivision(new Division("Picagres"));
        mora.agregarSubdivision(new Division("Jaris"));
        mora.agregarSubdivision(new Division("Quitirrisí"));

// Cantón Goicoechea
        Division goicoechea = new Division("Goicoechea");
        goicoechea.agregarSubdivision(new Division("Guadalupe"));
        goicoechea.agregarSubdivision(new Division("San Francisco"));
        goicoechea.agregarSubdivision(new Division("Calle Blancos"));
        goicoechea.agregarSubdivision(new Division("Mata de Plátano"));
        goicoechea.agregarSubdivision(new Division("Ipís"));
        goicoechea.agregarSubdivision(new Division("Rancho Redondo"));
        goicoechea.agregarSubdivision(new Division("Purral"));

// Cantón Santa Ana
        Division santaAna = new Division("Santa Ana");
        santaAna.agregarSubdivision(new Division("Santa Ana"));
        santaAna.agregarSubdivision(new Division("Salitral"));
        santaAna.agregarSubdivision(new Division("Pozos"));
        santaAna.agregarSubdivision(new Division("Uruca"));
        santaAna.agregarSubdivision(new Division("Piedades"));
        santaAna.agregarSubdivision(new Division("Brasil"));

// Cantón Alajuelita
        Division alajuelita = new Division("Alajuelita");
        alajuelita.agregarSubdivision(new Division("Alajuelita"));
        alajuelita.agregarSubdivision(new Division("San Josecito"));
        alajuelita.agregarSubdivision(new Division("San Antonio"));
        alajuelita.agregarSubdivision(new Division("Concepción"));
        alajuelita.agregarSubdivision(new Division("San Felipe"));

// Cantón Vázquez de Coronado
        Division coronado = new Division("Vázquez de Coronado");
        coronado.agregarSubdivision(new Division("San Isidro"));
        coronado.agregarSubdivision(new Division("San Rafael"));
        coronado.agregarSubdivision(new Division("Dulce Nombre de Jesús"));
        coronado.agregarSubdivision(new Division("Patalillo"));
        coronado.agregarSubdivision(new Division("Cascajal"));

// Cantón Acosta
        Division acosta = new Division("Acosta");
        acosta.agregarSubdivision(new Division("San Ignacio"));
        acosta.agregarSubdivision(new Division("Guaitil"));
        acosta.agregarSubdivision(new Division("Palmichal"));
        acosta.agregarSubdivision(new Division("Cangrejal"));
        acosta.agregarSubdivision(new Division("Sabanillas"));

// Cantón Tibás
        Division tibas = new Division("Tibás");
        tibas.agregarSubdivision(new Division("San Juan"));
        tibas.agregarSubdivision(new Division("Cinco Esquinas"));
        tibas.agregarSubdivision(new Division("Anselmo Llorente"));
        tibas.agregarSubdivision(new Division("León XIII"));
        tibas.agregarSubdivision(new Division("Colima"));

// Cantón Moravia
        Division moravia = new Division("Moravia");
        moravia.agregarSubdivision(new Division("San Vicente"));
        moravia.agregarSubdivision(new Division("San Jerónimo"));
        moravia.agregarSubdivision(new Division("La Trinidad"));

// Cantón Montes de Oca
        Division montesDeOca = new Division("Montes de Oca");
        montesDeOca.agregarSubdivision(new Division("San Pedro"));
        montesDeOca.agregarSubdivision(new Division("Sabanilla"));
        montesDeOca.agregarSubdivision(new Division("Mercedes"));
        montesDeOca.agregarSubdivision(new Division("San Rafael"));

// Cantón Turrubares
        Division turrubares = new Division("Turrubares");
        turrubares.agregarSubdivision(new Division("San Pablo"));
        turrubares.agregarSubdivision(new Division("San Pedro"));
        turrubares.agregarSubdivision(new Division("San Juan de Mata"));
        turrubares.agregarSubdivision(new Division("San Luis"));
        turrubares.agregarSubdivision(new Division("Carara"));

// Cantón Dota
        Division dota = new Division("Dota");
        dota.agregarSubdivision(new Division("Santa María"));
        dota.agregarSubdivision(new Division("Jardín"));
        dota.agregarSubdivision(new Division("Copey"));

// Cantón Curridabat
        Division curridabat = new Division("Curridabat");
        curridabat.agregarSubdivision(new Division("Curridabat"));
        curridabat.agregarSubdivision(new Division("Granadilla"));
        curridabat.agregarSubdivision(new Division("Sánchez"));
        curridabat.agregarSubdivision(new Division("Tirrases"));

// Cantón Pérez Zeledón
        Division perezZeledon = new Division("Pérez Zeledón");
        perezZeledon.agregarSubdivision(new Division("San Isidro de El General"));
        perezZeledon.agregarSubdivision(new Division("General"));
        perezZeledon.agregarSubdivision(new Division("Daniel Flores"));
        perezZeledon.agregarSubdivision(new Division("Rivas"));
        perezZeledon.agregarSubdivision(new Division("San Pedro"));
        perezZeledon.agregarSubdivision(new Division("Platanares"));
        perezZeledon.agregarSubdivision(new Division("Pejibaye"));
        perezZeledon.agregarSubdivision(new Division("Cajón"));
        perezZeledon.agregarSubdivision(new Division("Barú"));
        perezZeledon.agregarSubdivision(new Division("Río Nuevo"));
        perezZeledon.agregarSubdivision(new Division("Páramo"));
        perezZeledon.agregarSubdivision(new Division("La Amistad"));

// Cantón León Cortés Castro
        Division leonCortes = new Division("León Cortés Castro");
        leonCortes.agregarSubdivision(new Division("San Pablo"));
        leonCortes.agregarSubdivision(new Division("San Andrés"));
        leonCortes.agregarSubdivision(new Division("Llano Bonito"));
        leonCortes.agregarSubdivision(new Division("San Isidro"));
        leonCortes.agregarSubdivision(new Division("Santa Cruz"));
        leonCortes.agregarSubdivision(new Division("San Antonio"));

// Agregar todos los cantones a San José
        sanJose.agregarSubdivision(central);
        sanJose.agregarSubdivision(escazu);
        sanJose.agregarSubdivision(desamparados);
        sanJose.agregarSubdivision(puriscal);
        sanJose.agregarSubdivision(tarrazu);
        sanJose.agregarSubdivision(aserri);
        sanJose.agregarSubdivision(mora);
        sanJose.agregarSubdivision(goicoechea);
        sanJose.agregarSubdivision(santaAna);
        sanJose.agregarSubdivision(alajuelita);
        sanJose.agregarSubdivision(coronado);
        sanJose.agregarSubdivision(acosta);
        sanJose.agregarSubdivision(tibas);
        sanJose.agregarSubdivision(moravia);
        sanJose.agregarSubdivision(montesDeOca);
        sanJose.agregarSubdivision(turrubares);
        sanJose.agregarSubdivision(dota);
        sanJose.agregarSubdivision(curridabat);
        sanJose.agregarSubdivision(perezZeledon);
        sanJose.agregarSubdivision(leonCortes);
        
        // Alajuela
        Division alajuela = new Division("Alajuela");

        // Cantón Alajuela (Central)
        Division centralAlajuela = new Division("Central");
        centralAlajuela.agregarSubdivision(new Division("Alajuela"));
        centralAlajuela.agregarSubdivision(new Division("San José"));
        centralAlajuela.agregarSubdivision(new Division("Carrizal"));
        centralAlajuela.agregarSubdivision(new Division("San Antonio"));
        centralAlajuela.agregarSubdivision(new Division("Guácima"));
        centralAlajuela.agregarSubdivision(new Division("San Isidro"));
        centralAlajuela.agregarSubdivision(new Division("Sabanilla"));
        centralAlajuela.agregarSubdivision(new Division("San Rafael"));
        centralAlajuela.agregarSubdivision(new Division("Río Segundo"));
        centralAlajuela.agregarSubdivision(new Division("Desamparados"));
        centralAlajuela.agregarSubdivision(new Division("Turrúcares"));
        centralAlajuela.agregarSubdivision(new Division("Tambor"));
        centralAlajuela.agregarSubdivision(new Division("Garita"));
        centralAlajuela.agregarSubdivision(new Division("Sarapiquí"));

        // Cantón San Ramón
        Division sanRamon = new Division("San Ramón");
        sanRamon.agregarSubdivision(new Division("San Ramón"));
        sanRamon.agregarSubdivision(new Division("Santiago"));
        sanRamon.agregarSubdivision(new Division("San Juan"));
        sanRamon.agregarSubdivision(new Division("Piedades Norte"));
        sanRamon.agregarSubdivision(new Division("Piedades Sur"));
        sanRamon.agregarSubdivision(new Division("San Rafael"));
        sanRamon.agregarSubdivision(new Division("San Isidro"));
        sanRamon.agregarSubdivision(new Division("Ángeles"));
        sanRamon.agregarSubdivision(new Division("Alfaro"));
        sanRamon.agregarSubdivision(new Division("Volio"));
        sanRamon.agregarSubdivision(new Division("Concepción"));
        sanRamon.agregarSubdivision(new Division("Zapotal"));
        sanRamon.agregarSubdivision(new Division("Peñas Blancas"));

        // Cantón Grecia
        Division grecia = new Division("Grecia");
        grecia.agregarSubdivision(new Division("Grecia"));
        grecia.agregarSubdivision(new Division("San Isidro"));
        grecia.agregarSubdivision(new Division("San José"));
        grecia.agregarSubdivision(new Division("San Roque"));
        grecia.agregarSubdivision(new Division("Tacares"));
        grecia.agregarSubdivision(new Division("Río Cuarto"));
        grecia.agregarSubdivision(new Division("Puente de Piedra"));
        grecia.agregarSubdivision(new Division("Bolívar"));

        // Cantón San Mateo
        Division sanMateo = new Division("San Mateo");
        sanMateo.agregarSubdivision(new Division("San Mateo"));
        sanMateo.agregarSubdivision(new Division("Desmonte"));
        sanMateo.agregarSubdivision(new Division("Jesús María"));
        sanMateo.agregarSubdivision(new Division("Labrador"));

        // Cantón Atenas
        Division atenas = new Division("Atenas");
        atenas.agregarSubdivision(new Division("Atenas"));
        atenas.agregarSubdivision(new Division("Jesús"));
        atenas.agregarSubdivision(new Division("Mercedes"));
        atenas.agregarSubdivision(new Division("San Isidro"));
        atenas.agregarSubdivision(new Division("Concepción"));
        atenas.agregarSubdivision(new Division("San José"));
        atenas.agregarSubdivision(new Division("Santa Eulalia"));
        atenas.agregarSubdivision(new Division("Escobal"));

        // Cantón Naranjo
        Division naranjo = new Division("Naranjo");
        naranjo.agregarSubdivision(new Division("Naranjo"));
        naranjo.agregarSubdivision(new Division("San Miguel"));
        naranjo.agregarSubdivision(new Division("San José"));
        naranjo.agregarSubdivision(new Division("Cirrí Sur"));
        naranjo.agregarSubdivision(new Division("San Jerónimo"));
        naranjo.agregarSubdivision(new Division("San Juan"));
        naranjo.agregarSubdivision(new Division("Rosario"));
        naranjo.agregarSubdivision(new Division("Palmitos"));

        // Cantón Palmares
        Division palmares = new Division("Palmares");
        palmares.agregarSubdivision(new Division("Palmares"));
        palmares.agregarSubdivision(new Division("Zaragoza"));
        palmares.agregarSubdivision(new Division("Buenos Aires"));
        palmares.agregarSubdivision(new Division("Santiago"));
        palmares.agregarSubdivision(new Division("Candelaria"));
        palmares.agregarSubdivision(new Division("Esquipulas"));
        palmares.agregarSubdivision(new Division("La Granja"));

        // Cantón Poás
        Division poas = new Division("Poás");
        poas.agregarSubdivision(new Division("San Pedro"));
        poas.agregarSubdivision(new Division("San Juan"));
        poas.agregarSubdivision(new Division("San Rafael"));
        poas.agregarSubdivision(new Division("Carrillos"));
        poas.agregarSubdivision(new Division("Sabana Redonda"));

        // Cantón Orotina
        Division orotina = new Division("Orotina");
        orotina.agregarSubdivision(new Division("Orotina"));
        orotina.agregarSubdivision(new Division("Mastate"));
        orotina.agregarSubdivision(new Division("Hacienda Vieja"));
        orotina.agregarSubdivision(new Division("Coyolar"));
        orotina.agregarSubdivision(new Division("La Ceiba"));

        // Cantón San Carlos
        Division sanCarlos = new Division("San Carlos");
        sanCarlos.agregarSubdivision(new Division("Quesada"));
        sanCarlos.agregarSubdivision(new Division("Florencia"));
        sanCarlos.agregarSubdivision(new Division("Buenavista"));
        sanCarlos.agregarSubdivision(new Division("Aguas Zarcas"));
        sanCarlos.agregarSubdivision(new Division("Venecia"));
        sanCarlos.agregarSubdivision(new Division("Pital"));
        sanCarlos.agregarSubdivision(new Division("La Fortuna"));
        sanCarlos.agregarSubdivision(new Division("La Tigra"));
        sanCarlos.agregarSubdivision(new Division("La Palmera"));
        sanCarlos.agregarSubdivision(new Division("Venado"));
        sanCarlos.agregarSubdivision(new Division("Cutris"));
        sanCarlos.agregarSubdivision(new Division("Monterrey"));
        sanCarlos.agregarSubdivision(new Division("Pocosol"));

        // Cantón Zarcero
        Division zarcero = new Division("Zarcero");
        zarcero.agregarSubdivision(new Division("Zarcero"));
        zarcero.agregarSubdivision(new Division("Laguna"));
        zarcero.agregarSubdivision(new Division("Tapesco"));
        zarcero.agregarSubdivision(new Division("Guadalupe"));
        zarcero.agregarSubdivision(new Division("Palmira"));
        zarcero.agregarSubdivision(new Division("Zapote"));
        zarcero.agregarSubdivision(new Division("Brisas"));

        // Cantón Valverde Vega
        Division valverdeVega = new Division("Valverde Vega");
        valverdeVega.agregarSubdivision(new Division("Sarchí Norte"));
        valverdeVega.agregarSubdivision(new Division("Sarchí Sur"));
        valverdeVega.agregarSubdivision(new Division("Toro Amarillo"));
        valverdeVega.agregarSubdivision(new Division("San Pedro"));
        valverdeVega.agregarSubdivision(new Division("Rodríguez"));

        // Cantón Upala
        Division upala = new Division("Upala");
        upala.agregarSubdivision(new Division("Upala"));
        upala.agregarSubdivision(new Division("Aguas Claras"));
        upala.agregarSubdivision(new Division("San José"));
        upala.agregarSubdivision(new Division("Bijagua"));
        upala.agregarSubdivision(new Division("Delicias"));
        upala.agregarSubdivision(new Division("Dos Ríos"));
        upala.agregarSubdivision(new Division("Yolillal"));
        upala.agregarSubdivision(new Division("Canalete"));

        // Cantón Los Chiles
        Division losChiles = new Division("Los Chiles");
        losChiles.agregarSubdivision(new Division("Los Chiles"));
        losChiles.agregarSubdivision(new Division("Caño Negro"));
        losChiles.agregarSubdivision(new Division("El Amparo"));
        losChiles.agregarSubdivision(new Division("San Jorge"));

        // Cantón Guatuso
        Division guatuso = new Division("Guatuso");
        guatuso.agregarSubdivision(new Division("San Rafael"));
        guatuso.agregarSubdivision(new Division("Buenavista"));
        guatuso.agregarSubdivision(new Division("Cote"));
        guatuso.agregarSubdivision(new Division("Katira"));

        // Cantón Río Cuarto
        Division rioCuarto = new Division("Río Cuarto");
        rioCuarto.agregarSubdivision(new Division("Río Cuarto"));
        rioCuarto.agregarSubdivision(new Division("Santa Isabel"));
        rioCuarto.agregarSubdivision(new Division("Santa Rita"));


        alajuela.agregarSubdivision(centralAlajuela);
        alajuela.agregarSubdivision(sanRamon);
        alajuela.agregarSubdivision(grecia);
        alajuela.agregarSubdivision(sanMateo);
        alajuela.agregarSubdivision(atenas);
        alajuela.agregarSubdivision(naranjo);
        alajuela.agregarSubdivision(palmares);
        alajuela.agregarSubdivision(poas);
        alajuela.agregarSubdivision(orotina);
        alajuela.agregarSubdivision(sanCarlos);
        alajuela.agregarSubdivision(zarcero);
        alajuela.agregarSubdivision(valverdeVega);
        alajuela.agregarSubdivision(upala);
        alajuela.agregarSubdivision(losChiles);
        alajuela.agregarSubdivision(guatuso);
        alajuela.agregarSubdivision(rioCuarto);
        
        // Cartago
        Division cartago = new Division("Cartago");

// Cantón Cartago (Central)
        Division centralCartago = new Division("Central");
        centralCartago.agregarSubdivision(new Division("Oriental"));
        centralCartago.agregarSubdivision(new Division("Occidental"));
        centralCartago.agregarSubdivision(new Division("Carmen"));
        centralCartago.agregarSubdivision(new Division("San Nicolás"));
        centralCartago.agregarSubdivision(new Division("Aguacaliente (San Francisco)"));
        centralCartago.agregarSubdivision(new Division("Guadalupe (Arenilla)"));
        centralCartago.agregarSubdivision(new Division("Corralillo"));
        centralCartago.agregarSubdivision(new Division("Tierra Blanca"));
        centralCartago.agregarSubdivision(new Division("Dulce Nombre"));
        centralCartago.agregarSubdivision(new Division("Llano Grande"));
        centralCartago.agregarSubdivision(new Division("Quebradilla"));

// Cantón Paraíso
        Division paraiso = new Division("Paraíso");
        paraiso.agregarSubdivision(new Division("Paraíso"));
        paraiso.agregarSubdivision(new Division("Santiago"));
        paraiso.agregarSubdivision(new Division("Orosi"));
        paraiso.agregarSubdivision(new Division("Cachí"));
        paraiso.agregarSubdivision(new Division("Llanos de Santa Lucía"));

// Cantón La Unión
        Division laUnion = new Division("La Unión");
        laUnion.agregarSubdivision(new Division("Tres Ríos"));
        laUnion.agregarSubdivision(new Division("San Diego"));
        laUnion.agregarSubdivision(new Division("San Juan"));
        laUnion.agregarSubdivision(new Division("San Rafael"));
        laUnion.agregarSubdivision(new Division("Concepción"));
        laUnion.agregarSubdivision(new Division("Dulce Nombre"));
        laUnion.agregarSubdivision(new Division("San Ramón"));
        laUnion.agregarSubdivision(new Division("Río Azul"));

// Cantón Jiménez
        Division jimenez = new Division("Jiménez");
        jimenez.agregarSubdivision(new Division("Juan Viñas"));
        jimenez.agregarSubdivision(new Division("Tucurrique"));
        jimenez.agregarSubdivision(new Division("Pejibaye"));

// Cantón Turrialba
        Division turrialba = new Division("Turrialba");
        turrialba.agregarSubdivision(new Division("Turrialba"));
        turrialba.agregarSubdivision(new Division("La Suiza"));
        turrialba.agregarSubdivision(new Division("Peralta"));
        turrialba.agregarSubdivision(new Division("Santa Cruz"));
        turrialba.agregarSubdivision(new Division("Santa Teresita"));
        turrialba.agregarSubdivision(new Division("Pavones"));
        turrialba.agregarSubdivision(new Division("Tuis"));
        turrialba.agregarSubdivision(new Division("Tayutic"));
        turrialba.agregarSubdivision(new Division("Santa Rosa"));
        turrialba.agregarSubdivision(new Division("Tres Equis"));
        turrialba.agregarSubdivision(new Division("La Isabel"));
        turrialba.agregarSubdivision(new Division("Chirripó"));

// Cantón Alvarado
        Division alvarado = new Division("Alvarado");
        alvarado.agregarSubdivision(new Division("Pacayas"));
        alvarado.agregarSubdivision(new Division("Cervantes"));
        alvarado.agregarSubdivision(new Division("Capellades"));

// Cantón Oreamuno
        Division oreamuno = new Division("Oreamuno");
        oreamuno.agregarSubdivision(new Division("San Rafael"));
        oreamuno.agregarSubdivision(new Division("Cot"));
        oreamuno.agregarSubdivision(new Division("Potrero Cerrado"));
        oreamuno.agregarSubdivision(new Division("Cipreses"));
        oreamuno.agregarSubdivision(new Division("Santa Rosa"));

// Cantón El Guarco
        Division elGuarco = new Division("El Guarco");
        elGuarco.agregarSubdivision(new Division("El Tejar"));
        elGuarco.agregarSubdivision(new Division("San Isidro"));
        elGuarco.agregarSubdivision(new Division("Tobosi"));
        elGuarco.agregarSubdivision(new Division("Patio de Agua"));

// Agregar todos los cantones a Cartago
        cartago.agregarSubdivision(centralCartago);
        cartago.agregarSubdivision(paraiso);
        cartago.agregarSubdivision(laUnion);
        cartago.agregarSubdivision(jimenez);
        cartago.agregarSubdivision(turrialba);
        cartago.agregarSubdivision(alvarado);
        cartago.agregarSubdivision(oreamuno);
        cartago.agregarSubdivision(elGuarco);
        
        // Heredia
        Division heredia = new Division("Heredia");

// Cantón Heredia (Central)
        Division centralHeredia = new Division("Central");
        centralHeredia.agregarSubdivision(new Division("Heredia"));
        centralHeredia.agregarSubdivision(new Division("Mercedes"));
        centralHeredia.agregarSubdivision(new Division("San Francisco"));
        centralHeredia.agregarSubdivision(new Division("Ulloa"));
        centralHeredia.agregarSubdivision(new Division("Varablanca"));

// Cantón Barva
        Division barva = new Division("Barva");
        barva.agregarSubdivision(new Division("Barva"));
        barva.agregarSubdivision(new Division("San Pedro"));
        barva.agregarSubdivision(new Division("San Pablo"));
        barva.agregarSubdivision(new Division("San Roque"));
        barva.agregarSubdivision(new Division("Santa Lucía"));
        barva.agregarSubdivision(new Division("San José de la Montaña"));

// Cantón Santo Domingo
        Division santoDomingo = new Division("Santo Domingo");
        santoDomingo.agregarSubdivision(new Division("Santo Domingo"));
        santoDomingo.agregarSubdivision(new Division("San Vicente"));
        santoDomingo.agregarSubdivision(new Division("San Miguel"));
        santoDomingo.agregarSubdivision(new Division("Paracito"));
        santoDomingo.agregarSubdivision(new Division("Santo Tomás"));
        santoDomingo.agregarSubdivision(new Division("Santa Rosa"));
        santoDomingo.agregarSubdivision(new Division("Tures"));
        santoDomingo.agregarSubdivision(new Division("Pará"));

// Cantón Santa Bárbara
        Division santaBarbara = new Division("Santa Bárbara");
        santaBarbara.agregarSubdivision(new Division("Santa Bárbara"));
        santaBarbara.agregarSubdivision(new Division("San Pedro"));
        santaBarbara.agregarSubdivision(new Division("San Juan"));
        santaBarbara.agregarSubdivision(new Division("Jesús"));
        santaBarbara.agregarSubdivision(new Division("Santo Domingo"));
        santaBarbara.agregarSubdivision(new Division("Purabá"));

// Cantón San Rafael
        Division sanRafael = new Division("San Rafael");
        sanRafael.agregarSubdivision(new Division("San Rafael"));
        sanRafael.agregarSubdivision(new Division("San Josecito"));
        sanRafael.agregarSubdivision(new Division("Santiago"));
        sanRafael.agregarSubdivision(new Division("Ángeles"));
        sanRafael.agregarSubdivision(new Division("Concepción"));

// Cantón San Isidro
        Division sanIsidro = new Division("San Isidro");
        sanIsidro.agregarSubdivision(new Division("San Isidro"));
        sanIsidro.agregarSubdivision(new Division("San José"));
        sanIsidro.agregarSubdivision(new Division("Concepción"));
        sanIsidro.agregarSubdivision(new Division("San Francisco"));

// Cantón Belén
        Division belen = new Division("Belén");
        belen.agregarSubdivision(new Division("San Antonio"));
        belen.agregarSubdivision(new Division("La Ribera"));
        belen.agregarSubdivision(new Division("La Asunción"));

// Cantón Flores
        Division flores = new Division("Flores");
        flores.agregarSubdivision(new Division("San Joaquín"));
        flores.agregarSubdivision(new Division("Barrantes"));
        flores.agregarSubdivision(new Division("Llorente"));

// Cantón San Pablo
        Division sanPablo = new Division("San Pablo");
        sanPablo.agregarSubdivision(new Division("San Pablo"));
        sanPablo.agregarSubdivision(new Division("Rincón de Sabanilla"));

// Cantón Sarapiquí
        Division sarapiqui = new Division("Sarapiquí");
        sarapiqui.agregarSubdivision(new Division("Puerto Viejo"));
        sarapiqui.agregarSubdivision(new Division("La Virgen"));
        sarapiqui.agregarSubdivision(new Division("Horquetas"));
        sarapiqui.agregarSubdivision(new Division("Llanuras del Gaspar"));
        sarapiqui.agregarSubdivision(new Division("Cureña"));

// Agregar todos los cantones a Heredia
        heredia.agregarSubdivision(centralHeredia);
        heredia.agregarSubdivision(barva);
        heredia.agregarSubdivision(santoDomingo);
        heredia.agregarSubdivision(santaBarbara);
        heredia.agregarSubdivision(sanRafael);
        heredia.agregarSubdivision(sanIsidro);
        heredia.agregarSubdivision(belen);
        heredia.agregarSubdivision(flores);
        heredia.agregarSubdivision(sanPablo);
        heredia.agregarSubdivision(sarapiqui);
        
        // Guanacaste
        Division guanacaste = new Division("Guanacaste");

// Cantón Liberia
        Division liberia = new Division("Liberia");
        liberia.agregarSubdivision(new Division("Liberia"));
        liberia.agregarSubdivision(new Division("Cañas Dulces"));
        liberia.agregarSubdivision(new Division("Mayorga"));
        liberia.agregarSubdivision(new Division("Nacascolo"));
        liberia.agregarSubdivision(new Division("Curubandé"));

// Cantón Nicoya
        Division nicoya = new Division("Nicoya");
        nicoya.agregarSubdivision(new Division("Nicoya"));
        nicoya.agregarSubdivision(new Division("Mansión"));
        nicoya.agregarSubdivision(new Division("San Antonio"));
        nicoya.agregarSubdivision(new Division("Quebrada Honda"));
        nicoya.agregarSubdivision(new Division("Sámara"));
        nicoya.agregarSubdivision(new Division("Nosara"));
        nicoya.agregarSubdivision(new Division("Belén de Nosarita"));

// Cantón Santa Cruz
        Division santaCruz = new Division("Santa Cruz");
        santaCruz.agregarSubdivision(new Division("Santa Cruz"));
        santaCruz.agregarSubdivision(new Division("Bolsón"));
        santaCruz.agregarSubdivision(new Division("Veintisiete de Abril"));
        santaCruz.agregarSubdivision(new Division("Tempate"));
        santaCruz.agregarSubdivision(new Division("Cartagena"));
        santaCruz.agregarSubdivision(new Division("Cuajiniquil"));
        santaCruz.agregarSubdivision(new Division("Diriá"));
        santaCruz.agregarSubdivision(new Division("Cabo Velas"));
        santaCruz.agregarSubdivision(new Division("Tamarindo"));

// Cantón Bagaces
        Division bagaces = new Division("Bagaces");
        bagaces.agregarSubdivision(new Division("Bagaces"));
        bagaces.agregarSubdivision(new Division("Fortuna"));
        bagaces.agregarSubdivision(new Division("Mogote"));
        bagaces.agregarSubdivision(new Division("Río Naranjo"));

// Cantón Carrillo
        Division carrillo = new Division("Carrillo");
        carrillo.agregarSubdivision(new Division("Filadelfia"));
        carrillo.agregarSubdivision(new Division("Palmira"));
        carrillo.agregarSubdivision(new Division("Sardinal"));
        carrillo.agregarSubdivision(new Division("Belén"));

// Cantón Cañas
        Division canas = new Division("Cañas");
        canas.agregarSubdivision(new Division("Cañas"));
        canas.agregarSubdivision(new Division("Palmira"));
        canas.agregarSubdivision(new Division("San Miguel"));
        canas.agregarSubdivision(new Division("Bebedero"));
        canas.agregarSubdivision(new Division("Porozal"));

// Cantón Abangares
        Division abangares = new Division("Abangares");
        abangares.agregarSubdivision(new Division("Las Juntas"));
        abangares.agregarSubdivision(new Division("Sierra"));
        abangares.agregarSubdivision(new Division("San Juan"));
        abangares.agregarSubdivision(new Division("Colorado"));

// Cantón Tilarán
        Division tilaran = new Division("Tilarán");
        tilaran.agregarSubdivision(new Division("Tilarán"));
        tilaran.agregarSubdivision(new Division("Quebrada Grande"));
        tilaran.agregarSubdivision(new Division("Tronadora"));
        tilaran.agregarSubdivision(new Division("Santa Rosa"));
        tilaran.agregarSubdivision(new Division("Líbano"));
        tilaran.agregarSubdivision(new Division("Tierras Morenas"));
        tilaran.agregarSubdivision(new Division("Arenal"));

// Cantón Nandayure
        Division nandayure = new Division("Nandayure");
        nandayure.agregarSubdivision(new Division("Carmona"));
        nandayure.agregarSubdivision(new Division("Santa Rita"));
        nandayure.agregarSubdivision(new Division("Zapotal"));
        nandayure.agregarSubdivision(new Division("San Pablo"));
        nandayure.agregarSubdivision(new Division("Porvenir"));
        nandayure.agregarSubdivision(new Division("Bejuco"));

// Cantón La Cruz
        Division laCruz = new Division("La Cruz");
        laCruz.agregarSubdivision(new Division("La Cruz"));
        laCruz.agregarSubdivision(new Division("Santa Cecilia"));
        laCruz.agregarSubdivision(new Division("La Garita"));
        laCruz.agregarSubdivision(new Division("Santa Elena"));

// Cantón Hojancha
        Division hojancha = new Division("Hojancha");
        hojancha.agregarSubdivision(new Division("Hojancha"));
        hojancha.agregarSubdivision(new Division("Monte Romo"));
        hojancha.agregarSubdivision(new Division("Puerto Carrillo"));
        hojancha.agregarSubdivision(new Division("Huacas"));
        hojancha.agregarSubdivision(new Division("Matambú"));

// Agregar todos los cantones a Guanacaste
        guanacaste.agregarSubdivision(liberia);
        guanacaste.agregarSubdivision(nicoya);
        guanacaste.agregarSubdivision(santaCruz);
        guanacaste.agregarSubdivision(bagaces);
        guanacaste.agregarSubdivision(carrillo);
        guanacaste.agregarSubdivision(canas);
        guanacaste.agregarSubdivision(abangares);
        guanacaste.agregarSubdivision(tilaran);
        guanacaste.agregarSubdivision(nandayure);
        guanacaste.agregarSubdivision(laCruz);
        guanacaste.agregarSubdivision(hojancha);
        
        // Puntarenas
        Division puntarenas = new Division("Puntarenas");

// Cantón Puntarenas (Central)
        Division centralPuntarenas = new Division("Central");
        centralPuntarenas.agregarSubdivision(new Division("Puntarenas"));
        centralPuntarenas.agregarSubdivision(new Division("Pitahaya"));
        centralPuntarenas.agregarSubdivision(new Division("Chomes"));
        centralPuntarenas.agregarSubdivision(new Division("Lepanto"));
        centralPuntarenas.agregarSubdivision(new Division("Paquera"));
        centralPuntarenas.agregarSubdivision(new Division("Manzanillo"));
        centralPuntarenas.agregarSubdivision(new Division("Guacimal"));
        centralPuntarenas.agregarSubdivision(new Division("Barranca"));
        centralPuntarenas.agregarSubdivision(new Division("Monte Verde"));
        centralPuntarenas.agregarSubdivision(new Division("Isla del Coco"));
        centralPuntarenas.agregarSubdivision(new Division("Cóbano"));
        centralPuntarenas.agregarSubdivision(new Division("Chacarita"));
        centralPuntarenas.agregarSubdivision(new Division("Chira"));
        centralPuntarenas.agregarSubdivision(new Division("Acapulco"));
        centralPuntarenas.agregarSubdivision(new Division("El Roble"));
        centralPuntarenas.agregarSubdivision(new Division("Arancibia"));

// Cantón Esparza
        Division esparza = new Division("Esparza");
        esparza.agregarSubdivision(new Division("Espíritu Santo"));
        esparza.agregarSubdivision(new Division("San Juan Grande"));
        esparza.agregarSubdivision(new Division("Macacona"));
        esparza.agregarSubdivision(new Division("San Rafael"));
        esparza.agregarSubdivision(new Division("San Jerónimo"));
        esparza.agregarSubdivision(new Division("Caldera"));

// Cantón Buenos Aires
        Division buenosAires = new Division("Buenos Aires");
        buenosAires.agregarSubdivision(new Division("Buenos Aires"));
        buenosAires.agregarSubdivision(new Division("Volcán"));
        buenosAires.agregarSubdivision(new Division("Potrero Grande"));
        buenosAires.agregarSubdivision(new Division("Boruca"));
        buenosAires.agregarSubdivision(new Division("Pilas"));
        buenosAires.agregarSubdivision(new Division("Colinas"));
        buenosAires.agregarSubdivision(new Division("Chánguena"));
        buenosAires.agregarSubdivision(new Division("Biolley"));
        buenosAires.agregarSubdivision(new Division("Brunka"));

// Cantón Montes de Oro
        Division montesDeOro = new Division("Montes de Oro");
        montesDeOro.agregarSubdivision(new Division("Miramar"));
        montesDeOro.agregarSubdivision(new Division("La Unión"));
        montesDeOro.agregarSubdivision(new Division("San Isidro"));

// Cantón Osa
        Division osa = new Division("Osa");
        osa.agregarSubdivision(new Division("Puerto Cortés"));
        osa.agregarSubdivision(new Division("Palmar"));
        osa.agregarSubdivision(new Division("Sierpe"));
        osa.agregarSubdivision(new Division("Bahía Ballena"));
        osa.agregarSubdivision(new Division("Piedras Blancas"));
        osa.agregarSubdivision(new Division("Bahía Drake"));

// Cantón Quepos (antes Aguirre)
        Division quepos = new Division("Quepos");
        quepos.agregarSubdivision(new Division("Quepos"));
        quepos.agregarSubdivision(new Division("Savegre"));
        quepos.agregarSubdivision(new Division("Naranjito"));

// Cantón Golfito
        Division golfito = new Division("Golfito");
        golfito.agregarSubdivision(new Division("Golfito"));
        golfito.agregarSubdivision(new Division("Puerto Jiménez"));
        golfito.agregarSubdivision(new Division("Guaycará"));
        golfito.agregarSubdivision(new Division("Pavón"));

// Cantón Coto Brus
        Division cotoBrus = new Division("Coto Brus");
        cotoBrus.agregarSubdivision(new Division("San Vito"));
        cotoBrus.agregarSubdivision(new Division("Sabalito"));
        cotoBrus.agregarSubdivision(new Division("Aguabuena"));
        cotoBrus.agregarSubdivision(new Division("Limoncito"));
        cotoBrus.agregarSubdivision(new Division("Pittier"));
        cotoBrus.agregarSubdivision(new Division("Gutiérrez Braun"));

// Cantón Parrita
        Division parrita = new Division("Parrita");
        parrita.agregarSubdivision(new Division("Parrita"));

// Cantón Corredores
        Division corredores = new Division("Corredores");
        corredores.agregarSubdivision(new Division("Corredor"));
        corredores.agregarSubdivision(new Division("La Cuesta"));
        corredores.agregarSubdivision(new Division("Canoas"));
        corredores.agregarSubdivision(new Division("Laurel"));

// Cantón Garabito
        Division garabito = new Division("Garabito");
        garabito.agregarSubdivision(new Division("Jacó"));
        garabito.agregarSubdivision(new Division("Tárcoles"));

// Agregar todos los cantones a Puntarenas
        puntarenas.agregarSubdivision(centralPuntarenas);
        puntarenas.agregarSubdivision(esparza);
        puntarenas.agregarSubdivision(buenosAires);
        puntarenas.agregarSubdivision(montesDeOro);
        puntarenas.agregarSubdivision(osa);
        puntarenas.agregarSubdivision(quepos);
        puntarenas.agregarSubdivision(golfito);
        puntarenas.agregarSubdivision(cotoBrus);
        puntarenas.agregarSubdivision(parrita);
        puntarenas.agregarSubdivision(corredores);
        puntarenas.agregarSubdivision(garabito);
        
        // Limón
        Division limon = new Division("Limón");

// Cantón Limón (Central)
        Division centralLimon = new Division("Central");
        centralLimon.agregarSubdivision(new Division("Limón"));
        centralLimon.agregarSubdivision(new Division("Valle La Estrella"));
        centralLimon.agregarSubdivision(new Division("Río Blanco"));
        centralLimon.agregarSubdivision(new Division("Matama"));

// Cantón Pococí
        Division pococi = new Division("Pococí");
        pococi.agregarSubdivision(new Division("Guápiles"));
        pococi.agregarSubdivision(new Division("Jiménez"));
        pococi.agregarSubdivision(new Division("Rita"));
        pococi.agregarSubdivision(new Division("Roxana"));
        pococi.agregarSubdivision(new Division("Cariari"));
        pococi.agregarSubdivision(new Division("Colorado"));
        pococi.agregarSubdivision(new Division("La Colonia"));

// Cantón Siquirres
        Division siquirres = new Division("Siquirres");
        siquirres.agregarSubdivision(new Division("Siquirres"));
        siquirres.agregarSubdivision(new Division("Pacuarito"));
        siquirres.agregarSubdivision(new Division("Florida"));
        siquirres.agregarSubdivision(new Division("Germania"));
        siquirres.agregarSubdivision(new Division("Cairo"));
        siquirres.agregarSubdivision(new Division("Alegría"));
        siquirres.agregarSubdivision(new Division("Reventazón"));

// Cantón Talamanca
        Division talamanca = new Division("Talamanca");
        talamanca.agregarSubdivision(new Division("Bratsi"));
        talamanca.agregarSubdivision(new Division("Sixaola"));
        talamanca.agregarSubdivision(new Division("Cahuita"));
        talamanca.agregarSubdivision(new Division("Telire"));

// Cantón Matina
        Division matina = new Division("Matina");
        matina.agregarSubdivision(new Division("Matina"));
        matina.agregarSubdivision(new Division("Batán"));
        matina.agregarSubdivision(new Division("Carrandi"));

// Cantón Guácimo
        Division guacimo = new Division("Guácimo");
        guacimo.agregarSubdivision(new Division("Guácimo"));
        guacimo.agregarSubdivision(new Division("Mercedes"));
        guacimo.agregarSubdivision(new Division("Pocora"));
        guacimo.agregarSubdivision(new Division("Río Jiménez"));
        guacimo.agregarSubdivision(new Division("Duacarí"));

// Agregar todos los cantones a Limón
        limon.agregarSubdivision(centralLimon);
        limon.agregarSubdivision(pococi);
        limon.agregarSubdivision(siquirres);
        limon.agregarSubdivision(talamanca);
        limon.agregarSubdivision(matina);
        limon.agregarSubdivision(guacimo);
        
        // Agregando todas las provincias a la lista
        provincias.add(sanJose);
        provincias.add(alajuela);
        provincias.add(cartago);
        provincias.add(heredia);
        provincias.add(guanacaste);
        provincias.add(puntarenas);
        provincias.add(limon);
    }
    
    public List<Division> getProvincias() {
        return provincias;
    }
    
    public List<String> getNombresProvincias() {
        List<String> nombres = new ArrayList<>();
        for (Division provincia : provincias) {
            nombres.add(provincia.getNombre());
        }
        return nombres;
    }
    
    public Division getProvincia(String nombre) {
        for (Division provincia : provincias) {
            if (provincia.getNombre().equals(nombre)) {
                return provincia;
            }
        }
        return null;
    }
}
