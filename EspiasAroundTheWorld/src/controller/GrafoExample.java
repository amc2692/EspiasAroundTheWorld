package controller;

import grafos.Grafo;

public class GrafoExample {
	
public static Grafo crearGrafoDePrueba() {
	
		Grafo grafo = new Grafo();
	/*
		grafo.crearVertice("0", Ubicacion.ARGENTINA);
		grafo.crearVertice("1", Ubicacion.AUSTRALIA);
		grafo.crearVertice("2", Ubicacion.BRASIL);
		grafo.crearVertice("3", Ubicacion.CHINA);
		grafo.crearVertice("4", Ubicacion.EGIPTO);
		grafo.crearVertice("5", Ubicacion.INGLATERRA);
		
		grafo.agregarArista(0, 2, 1);
		grafo.agregarArista(0, 4, 7);
		grafo.agregarArista(0, 1, 6);
		grafo.agregarArista(2, 5, 2);
		grafo.agregarArista(1, 3, 3);
		grafo.agregarArista(1, 4, 4);
		grafo.agregarArista(1, 5, 6);
		grafo.agregarArista(3, 5, 2);
		grafo.agregarArista(3, 4, 1);
		grafo.agregarArista(4, 5, 5);
	*/
	
	grafo.crearVertice("Buenos Aires 0", Ubicacion.BUENOS_AIRES);
	grafo.crearVertice("Catamarca 1", Ubicacion.CATAMARCA);
	grafo.crearVertice("Cordoba 2", Ubicacion.CORDOBA);
	grafo.crearVertice("Chaco 3", Ubicacion.CHACO);
	grafo.crearVertice("Chubut 4", Ubicacion.CHUBUT);
	grafo.crearVertice("Corrientes 5", Ubicacion.CORRIENTES);
	grafo.crearVertice("Entre Rios 6", Ubicacion.ENTRE_RIOS);
	grafo.crearVertice("Formosa 7", Ubicacion.FORMOSA);
	grafo.crearVertice("Jujuy 8", Ubicacion.JUJUY);
	grafo.crearVertice("La Pampa 9", Ubicacion.LA_PAMPA);
	grafo.crearVertice("La Rioja 10", Ubicacion.LA_RIOJA);
	grafo.crearVertice("Mendoza 11", Ubicacion.MENDOZA);
	grafo.crearVertice("Misiones 12", Ubicacion.MISIONES);
	grafo.crearVertice("Neuquen 13", Ubicacion.NEUQUEN);
	grafo.crearVertice("Rio Negro 14", Ubicacion.RIO_NEGRO);
	grafo.crearVertice("Salta 15", Ubicacion.SALTA);
	grafo.crearVertice("San Juan 16", Ubicacion.SAN_JUAN);
	grafo.crearVertice("San Luis 17", Ubicacion.SAN_LUIS);
	grafo.crearVertice("Santa Cruz 18", Ubicacion.SANTA_CRUZ);
	grafo.crearVertice("Santa Fe 19 ", Ubicacion.SANTA_FE);
	grafo.crearVertice("Santiago Del Estero 20 ", Ubicacion.SANTIAGO_DEL_ESTERO);
	grafo.crearVertice("Tierra del Fuego 21 ", Ubicacion.TIERRA_DEL_FUEGO);
	grafo.crearVertice("Tucuman 22", Ubicacion.TUCUMAN);
	
	
	
	
	grafo.agregarArista(0, 6, 375);
	grafo.agregarArista(0, 19, 393);
	grafo.agregarArista(0, 2, 646);
	grafo.agregarArista(0, 9, 749);
	grafo.agregarArista(0, 14, 799);
	grafo.agregarArista(1, 15, 410);
	grafo.agregarArista(1, 2, 362);
	grafo.agregarArista(1, 22, 189);
	grafo.agregarArista(6, 5, 500);
	grafo.agregarArista(6, 19, 19);
	grafo.agregarArista(5, 12, 291);
	grafo.agregarArista(5, 3, 13);
	grafo.agregarArista(5, 19, 498);
	grafo.agregarArista(19, 3, 495);
	grafo.agregarArista(19, 2, 330);
	grafo.agregarArista(19, 20, 547);	
	grafo.agregarArista(3, 7, 161);
	grafo.agregarArista(3, 20, 523);
	grafo.agregarArista(3, 15, 706);
	grafo.agregarArista(20, 2, 401);
	grafo.agregarArista(20, 1, 166);
	grafo.agregarArista(20, 22, 141);
	grafo.agregarArista(20, 15, 353);
	grafo.agregarArista(22, 2, 517);
	grafo.agregarArista(22, 15, 228);
	grafo.agregarArista(15, 8, 67);
	grafo.agregarArista(15, 7, 741);	
	grafo.agregarArista(1, 10, 149);
	grafo.agregarArista(10, 2, 340);
	grafo.agregarArista(10, 16, 283);
	grafo.agregarArista(10, 17, 435);
	grafo.agregarArista(16, 11, 152);
	grafo.agregarArista(16, 17, 284);	
	grafo.agregarArista(17, 2, 293);
	grafo.agregarArista(17, 9, 412);
	grafo.agregarArista(17, 11, 235);
	grafo.agregarArista(2, 9, 577);
	grafo.agregarArista(9, 14, 477);
	grafo.agregarArista(9, 13, 422);
	grafo.agregarArista(9, 11, 586);
	grafo.agregarArista(14, 13, 479);
	grafo.agregarArista(14, 4, 327);
	grafo.agregarArista(18, 4, 975);
	grafo.agregarArista(18, 21, 359);

	return grafo;
	}

}
