package metroparisien;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReseauMetro {
	
	public static List<Ligne> lignes;
  public static Map<String, Station> stations;

	public ReseauMetro() {
    	
    	//Création des stations 
        //Ligne 1
        Station defense = new Station("La Défense - Grande Arche", 1, false);
        Station esplanadeDeLaDefense = new Station("Esplanade de la Défense", 1, false);
        Station pontDeNeuilly = new Station("Pont de Neuilly", 1, false);
        Station lesSablons = new Station("Les Sablons (Jardin d'Acclimatation)", 1, false);
        Station porteMaillot = new Station("Porte Maillot (Palais des Congrès)", 1, false);
        Station argentine = new Station("Argentine", 1, false);
        Station charlesDeGaulleEtoile = new Station("Charles de Gaulle — Étoile", 1, false);
        Station georgeV = new Station("George V", 1, false);
        Station franklinDRoosevelt = new Station("Franklin D. Roosevelt", 1, false);
        Station champsElyseesClemenceau = new Station("Champs-Élysées — Clemenceau (Grand Palais)", 1, false);
        Station concorde = new Station("Concorde", 1, false);
        Station tuileries = new Station("Tuileries", 1, false);
        Station palaisRoyalMuseeDuLouvre = new Station("Palais Royal - Musée du Louvre", 1, false);
        Station louvreRivoli = new Station("Louvre — Rivoli", 1, false);
        Station chatelet = new Station("Châtelet", 1, false);
        Station hotelDeVille = new Station("Hôtel de Ville", 1, false);
        Station saintPaul = new Station("Saint-Paul (Le Marais)", 1, false);
        Station bastille = new Station("Bastille", 1, false);
        Station gareDeLyon = new Station("Gare de Lyon", 1, false);
        Station reuillyDiderot = new Station("Reuilly — Diderot", 1, false);
        Station nation = new Station("Nation", 1, false);
        Station porteDeVincennes = new Station("Porte de Vincennes", 1, false);
        Station saintMande = new Station("Saint-Mandé", 1, false);
        Station berault = new Station("Bérault", 1, false);
        Station chateauDeVincennes = new Station("Château de Vincennes", 1, false);
        
       
        
        Voie defense_esplanadeDeLaDefense = new Voie(defense, esplanadeDeLaDefense,1, false);
        Voie esplanadeDeLaDefense_pontDeNeuilly = new Voie(esplanadeDeLaDefense,pontDeNeuilly,2, false);
        Voie pontDeNeuilly_lesSablons = new Voie(pontDeNeuilly,lesSablons,1, false);
        Voie lesSablons_porteMaillot = new Voie(lesSablons,porteMaillot,2, false);
        Voie porteMaillot_argentine = new Voie(porteMaillot,argentine,1, false);
        Voie argentine_charlesDeGaulleEtoile = new Voie(argentine,charlesDeGaulleEtoile,2, false);
        Voie charlesDeGaulleEtoile_georgeV = new Voie(charlesDeGaulleEtoile,georgeV,1, false);
        Voie georgeV_franklinDRoosevelt = new Voie(georgeV,franklinDRoosevelt,1, false);
        Voie franklinDRoosevelt_champsElyseesClemenceau = new Voie(franklinDRoosevelt,champsElyseesClemenceau,2, false);
        Voie champsElyseesClemenceau_concorde = new Voie(champsElyseesClemenceau,concorde,1, false);
        Voie concorde_tuileries = new Voie(concorde,tuileries,1, false);
        Voie tuileries_palaisRoyalMuseeDuLouvre = new Voie(tuileries,palaisRoyalMuseeDuLouvre,2, false);
        Voie palaisRoyalMuseeDuLouvre_louvreRivoli = new Voie(palaisRoyalMuseeDuLouvre,louvreRivoli,1, false);
        Voie louvreRivoli_chatelet = new Voie(louvreRivoli,chatelet,1, false);
        Voie chatelet_hotelDeVille = new Voie(chatelet,hotelDeVille,1, false);
        Voie hotelDeVille_saintPaul = new Voie(hotelDeVille,saintPaul,2, false);
        Voie saintPaul_bastille = new Voie(saintPaul,bastille,2, false);
        Voie bastille_gareDeLyon = new Voie(bastille,gareDeLyon,2, false);
        Voie gareDeLyon_reuillyDiderot = new Voie(gareDeLyon,reuillyDiderot,2, false);
        Voie reuillyDiderot_nation = new Voie(reuillyDiderot,nation,2, false);
        Voie nation_porteDeVincennes = new Voie(nation,porteDeVincennes,1, false);
        Voie porteDeVincennes_saintMande = new Voie(porteDeVincennes,saintMande,2, false);
        Voie saintMande_berault = new Voie(saintMande,berault,2, false);
        Voie berault_chateauDeVincennes = new Voie(berault,chateauDeVincennes,2, false);
        
        List<Voie> voiesLigne1 = new ArrayList<Voie>();
        
        voiesLigne1.add(defense_esplanadeDeLaDefense);
        voiesLigne1.add(defense_esplanadeDeLaDefense);
        voiesLigne1.add(esplanadeDeLaDefense_pontDeNeuilly);
        voiesLigne1.add(pontDeNeuilly_lesSablons);
        voiesLigne1.add(lesSablons_porteMaillot);
        voiesLigne1.add(porteMaillot_argentine);
        voiesLigne1.add(argentine_charlesDeGaulleEtoile);
        voiesLigne1.add(charlesDeGaulleEtoile_georgeV);
        voiesLigne1.add(georgeV_franklinDRoosevelt);
        voiesLigne1.add(franklinDRoosevelt_champsElyseesClemenceau);
        voiesLigne1.add(champsElyseesClemenceau_concorde);
        voiesLigne1.add(concorde_tuileries);
        voiesLigne1.add(tuileries_palaisRoyalMuseeDuLouvre);
        voiesLigne1.add(palaisRoyalMuseeDuLouvre_louvreRivoli);
        voiesLigne1.add(louvreRivoli_chatelet);
        voiesLigne1.add(chatelet_hotelDeVille);
        voiesLigne1.add(hotelDeVille_saintPaul);
        voiesLigne1.add(saintPaul_bastille);
        voiesLigne1.add(bastille_gareDeLyon);
        voiesLigne1.add(gareDeLyon_reuillyDiderot);
        voiesLigne1.add(reuillyDiderot_nation);
        voiesLigne1.add(nation_porteDeVincennes);
        voiesLigne1.add(porteDeVincennes_saintMande);
        voiesLigne1.add(saintMande_berault);
        voiesLigne1.add(berault_chateauDeVincennes);
        
        
        Ligne ligne1 = new Ligne("ligne 1", voiesLigne1);
        
        
        //ligne 2 
        Station porteDauphine = new Station("Porte Dauphine (Maréchal de Lattre de Tassigny)", 1, false);
        Station victorHugo = new Station("Victor Hugo", 1, false);
      //charlesDeGaulleEtoile 
        Station ternes = new Station("Ternes", 1, false);
        Station courcelles = new Station("Courcelles", 1, false);
        Station monceau = new Station("Monceau",1, false);
        Station villiers = new Station("Villiers", 1, false);
        Station rome = new Station("Rome", 1, false);
        Station placeDeClichy = new Station("Place de Clichy", 1, false);
        Station blanche = new Station("Blanche", 1, false);
        Station pigalle = new Station("Pigalle", 1, false);
        Station anvers = new Station("Anvers (Sacré-Cœur)", 1, false);
        Station barbesRochechouart = new Station("Barbès - Rochechouart", 1, false);
        Station laChapelle = new Station("La Chapelle", 1, false);
        Station stalingrad = new Station("Stalingrad", 1, false);
        Station jaures = new Station("Jaurès", 1, false);
        Station colonelFabien = new Station("Colonel Fabien", 1, false);
        Station belleville = new Station("Belleville", 1, false);
        Station couronnes = new Station("Couronnes", 1, false);
        Station menilmontant = new Station("Ménilmontant", 1, false);
        Station pereLachaise = new Station("Père Lachaise", 1, false);
        Station philippeAuguste = new Station("Philippe Auguste", 1, false);
        Station alexandreDumas = new Station("Alexandre Dumas", 1, false);
        Station avron = new Station("Avron", 1, false);
        //nation
        
        
        //Les voies de la deuxième ligne 
        Voie porteDauphine_victorHugo = new Voie(porteDauphine, victorHugo,2, false);
        Voie victorHugo_charlesDeGaulleEtoile = new Voie(victorHugo,charlesDeGaulleEtoile,2, false);
        Voie charlesDeGaulleEtoile_ternes = new Voie(charlesDeGaulleEtoile, ternes, 1, false);
        Voie ternes_courcelles = new Voie(ternes, courcelles, 1, false);
        Voie courcelles_monceau = new Voie(courcelles, monceau, 1, false);
        Voie monceau_villiers = new Voie(monceau, villiers, 2, false);
        Voie villiers_rome = new Voie(villiers, rome, 1, false);
        Voie rome_placeDeClichy = new Voie(rome, placeDeClichy, 1, false);
        Voie placeDeClichy_blanche = new Voie(placeDeClichy, blanche, 2, false);
        Voie blanche_pigalle = new Voie(blanche, pigalle, 1, false);
        Voie pigalle_anvers = new Voie(pigalle, anvers, 1, false);
        Voie anvers_barbesRochechouart = new Voie(anvers, barbesRochechouart, 2, false);
        Voie barbesRochechouart_laChapelle = new Voie(barbesRochechouart, laChapelle, 1, false);
        Voie laChapelle_stalingrad = new Voie(laChapelle, stalingrad, 2, false);
        Voie stalingrad_jaures = new Voie(stalingrad, jaures, 1, false);
        Voie jaures_colonelFabien = new Voie(jaures, colonelFabien, 2, false);
        Voie colonelFabien_belleville = new Voie(colonelFabien, belleville, 1, false);
        Voie belleville_couronnes = new Voie(belleville, couronnes, 1, false);
        Voie couronnes_menilmontant = new Voie(couronnes, menilmontant, 2, false);
        Voie menilmontant_pereLachaise = new Voie(menilmontant, pereLachaise, 2, false);
        Voie pereLachaise_philippeAuguste = new Voie(pereLachaise, philippeAuguste, 1, false);
        Voie philippeAuguste_alexandreDumas = new Voie(philippeAuguste, alexandreDumas, 1, false);
        Voie alexandreDumas_avron = new Voie(alexandreDumas, avron, 2, false);
        Voie avron_nation = new Voie(avron, nation, 3, false);
                
        List<Voie> voiesLigne2 = new ArrayList<Voie>();
        
        voiesLigne2.add(porteDauphine_victorHugo);
        voiesLigne2.add(victorHugo_charlesDeGaulleEtoile);
        voiesLigne2.add(charlesDeGaulleEtoile_ternes);
        voiesLigne2.add(ternes_courcelles);
        voiesLigne2.add(courcelles_monceau);
        voiesLigne2.add(monceau_villiers);
        voiesLigne2.add(villiers_rome);
        voiesLigne2.add(rome_placeDeClichy);
        voiesLigne2.add(placeDeClichy_blanche);
        voiesLigne2.add(blanche_pigalle);
        voiesLigne2.add(pigalle_anvers);
        voiesLigne2.add(anvers_barbesRochechouart);
        voiesLigne2.add(barbesRochechouart_laChapelle);
        voiesLigne2.add(laChapelle_stalingrad);
        voiesLigne2.add(stalingrad_jaures);
        voiesLigne2.add(jaures_colonelFabien);
        voiesLigne2.add(colonelFabien_belleville);
        voiesLigne2.add(belleville_couronnes);
        voiesLigne2.add(couronnes_menilmontant);
        voiesLigne2.add(menilmontant_pereLachaise);
        voiesLigne2.add(pereLachaise_philippeAuguste);
        voiesLigne2.add(philippeAuguste_alexandreDumas);
        voiesLigne2.add(alexandreDumas_avron);
        voiesLigne2.add(avron_nation);
        
        Ligne ligne2 = new Ligne("ligne 2", voiesLigne2);
        
        //Ligne 3 
        Station pontDeLevalloisBecon = new Station("Pont de Levallois — Bécon", 1, false);
        Station anatoleFrance = new Station("Anatole France", 1, false);
        Station louiseMichel = new Station("Louise Michel", 1, false);
        Station porteDeChamperret = new Station("Porte de Champerret", 1, false);
        Station pereireMarJ = new Station("Pereire (Maréchal Juin)", 1, false);
        Station wagram = new Station("Wagram", 1, false);
        Station malesherbes = new Station("Malesherbes", 1, false);
        //villiers
        Station europe = new Station("Europe", 1, false);
        Station stLazare = new Station("Saint-Lazare", 1, false);
        Station havreCaumartin = new Station("Havre — Caumartin", 1, false);
        Station opera = new Station("Opéra", 1, false);
        Station quatreSeptembre = new Station("Quatre-Septembre", 1, false);
        Station bourse = new Station("Bourse", 1, false);
        Station sentier = new Station("Sentier", 1, false);
        Station reaumurSebastopol = new Station("Réaumur — Sébastopol", 1, false);
        Station artsMetiers = new Station("Arts et Métiers", 1, false);
        Station temple = new Station("Temple", 1, false);
        Station republique = new Station("République", 1, false);
        Station parmentier = new Station("Parmentier", 1, false);
        Station rueStMaur = new Station("Rue Saint-Maur", 1, false);
        //pereLachaise
        Station gambetta = new Station("Gambetta", 1, false);
        Station porteDeBagnolet = new Station("Porte de Bagnolet", 1, false);
        Station gallieni = new Station("Gallieni (Parc de Bagnolet)", 1, false);
        //Station gareEurolines = new Station("Gare Routière Internationale Eurolines", 3, false);
        
     // Création des voies de la ligne 3
        Voie pontDeLevalloisBecon_anatoleFrance = new Voie(pontDeLevalloisBecon, anatoleFrance, 1, false);
        Voie anatoleFrance_louiseMichel = new Voie(anatoleFrance, louiseMichel, 2, false);
        Voie louiseMichel_porteDeChamperret = new Voie(louiseMichel, porteDeChamperret, 2, false);
        Voie porteDeChamperret_pereireMarJ = new Voie(porteDeChamperret, pereireMarJ, 1, false);
        Voie pereireMarJ_wagram = new Voie(pereireMarJ, wagram, 2, false);
        Voie wagram_malesherbes = new Voie(wagram, malesherbes, 1, false);
        Voie malesherbes_villiers = new Voie(malesherbes, villiers, 1, false);
        Voie villiers_europe = new Voie(villiers, europe, 2, false);
        Voie europe_stLazare = new Voie(europe, stLazare, 2, false);
        Voie stLazare_havreCaumartin = new Voie(stLazare, havreCaumartin, 1, false);
        Voie havreCaumartin_opera = new Voie(havreCaumartin, opera, 1, false);
        Voie opera_quatreSeptembre = new Voie(opera, quatreSeptembre, 1, false);
        Voie quatreSeptembre_bourse = new Voie(quatreSeptembre, bourse, 1, false);
        Voie bourse_sentier = new Voie(bourse, sentier, 2, false);
        Voie sentier_reaumurSebastopol = new Voie(sentier, reaumurSebastopol, 1, false);
        Voie reaumurSebastopol_artsMetiers = new Voie(reaumurSebastopol, artsMetiers, 1, false);
        Voie artsMetiers_temple = new Voie(artsMetiers, temple, 1, false);
        Voie temple_republique = new Voie(temple, republique, 1, false);
        Voie republique_parmentier = new Voie(republique, parmentier, 2, false);
        Voie parmentier_rueStMaur = new Voie(parmentier, rueStMaur, 1, false);
        Voie rueStMaur_pereLachaise = new Voie(rueStMaur, pereLachaise, 1, false);
        Voie pereLachaise_gambetta = new Voie(pereLachaise, gambetta, 2, false);
        Voie gambetta_porteDeBagnolet = new Voie(gambetta, porteDeBagnolet, 2, false);
        Voie porteDeBagnolet_gallieni = new Voie(porteDeBagnolet, gallieni, 2, false);
        
        
        List<Voie> voiesLigne3 = new ArrayList<Voie>();
        
        voiesLigne3.add(pontDeLevalloisBecon_anatoleFrance);
        voiesLigne3.add(anatoleFrance_louiseMichel);
        voiesLigne3.add(louiseMichel_porteDeChamperret);
        voiesLigne3.add(porteDeChamperret_pereireMarJ);
        voiesLigne3.add(pereireMarJ_wagram);
        voiesLigne3.add(wagram_malesherbes);
        voiesLigne3.add(malesherbes_villiers);
        voiesLigne3.add(villiers_europe);
        voiesLigne3.add(europe_stLazare);
        voiesLigne3.add(stLazare_havreCaumartin);
        voiesLigne3.add(havreCaumartin_opera);
        voiesLigne3.add(opera_quatreSeptembre);
        voiesLigne3.add(quatreSeptembre_bourse);
        voiesLigne3.add(bourse_sentier);
        voiesLigne3.add(sentier_reaumurSebastopol);
        voiesLigne3.add(reaumurSebastopol_artsMetiers);
        voiesLigne3.add(artsMetiers_temple);
        voiesLigne3.add(temple_republique);
        voiesLigne3.add(republique_parmentier);
        voiesLigne3.add(parmentier_rueStMaur);
        voiesLigne3.add(rueStMaur_pereLachaise);
        voiesLigne3.add(pereLachaise_gambetta);
        voiesLigne3.add(gambetta_porteDeBagnolet);
        voiesLigne3.add(porteDeBagnolet_gallieni);
       
        
        Ligne ligne3 = new Ligne("ligne 3", voiesLigne3);
        
        //Ligne 3bis 
        
        Station porteDesLilas = new Station("Porte des Lilas", 1, false);
        Station saintFargeau = new Station("Saint-Fargeau", 1, false);
        Station pelleport = new Station("Pelleport", 1, false);
        //gambetta 
        
        Voie porteDesLilas_saintFargeau = new Voie(porteDesLilas, saintFargeau, 1, false);
        Voie saintFargeau_pelleport = new Voie(saintFargeau, pelleport, 1, false);
        Voie pelleport_gambetta = new Voie(pelleport, gambetta, 1, false);

        
        List<Voie> voiesLigne3bis = new ArrayList<Voie>();
        
        voiesLigne3bis.add(porteDesLilas_saintFargeau);
        voiesLigne3bis.add(saintFargeau_pelleport);
        voiesLigne3bis.add(pelleport_gambetta);
        
        Ligne ligne3bis = new Ligne("ligne 3bis", voiesLigne3bis);
        
        //Ligne 4 
        
        Station porteDeClignancourt = new Station("Porte de Clignancourt", 1, false);
        Station simplon = new Station("Simplon", 1, false);
        Station marcadetPoissonniers = new Station("Marcadet — Poissonniers", 1, false);
        Station chateauRouge = new Station("Château Rouge", 1, false);
        //barbesRochechouart 
        Station gareDuNord = new Station("Gare du Nord", 1, false);
        Station gareDeLEstVerdun = new Station("Gare de l'Est (Verdun)", 1, false);
        Station chateauDEau = new Station("Château d'Eau", 1, false);
        Station strasbourgSaintDenis = new Station("Strasbourg — Saint-Denis", 1, false);
        //reaumurSebastopol 
        Station etienneMarcel = new Station("Étienne Marcel", 1, false);
        Station lesHalles = new Station("Les Halles", 1, false);
        //chatelet
        Station cite = new Station("Cité", 1, false);
        Station saintMichel = new Station("Saint-Michel", 1, false);
        Station odeon = new Station("Odéon", 1, false);
        Station saintGermainDesPres = new Station("Saint-Germain-des-Prés", 1, false);
        Station saintSulpice = new Station("Saint-Sulpice", 1, false);
        Station saintPlacide = new Station("Saint-Placide", 1, false);
        Station montparnasseBienvenue = new Station("Montparnasse — Bienvenüe", 1, false);
        Station vavin = new Station("Vavin", 1, false);
        Station raspail = new Station("Raspail", 1, false);
        Station denfertRochereau = new Station("Denfert-Rochereau (Colonel Rol-Tanguy)", 1, false);
        Station moutonDuvernet = new Station("Mouton-Duvernet", 1, false);
        Station alesia = new Station("Alésia", 1, false);
        Station porteDOrleansLeclerc = new Station("Porte d'Orléans (Général Leclerc)", 1, false);
        Station mairieDeMontrouge = new Station("Mairie de Montrouge", 1, false);

        //Voies de la ligne 4 
     // Création des voies de la ligne 4
        Voie porteDeClignancourt_simplon = new Voie(porteDeClignancourt, simplon, 1, false);
        Voie simplon_marcadetPoissonniers = new Voie(simplon, marcadetPoissonniers, 1, false);
        Voie marcadetPoissonniers_chateauRouge = new Voie(marcadetPoissonniers, chateauRouge, 1, false);
        Voie chateauRouge_barbesRochechouart = new Voie(chateauRouge, barbesRochechouart,1, false);
        Voie barbesRochechouart_gareDuNord = new Voie(barbesRochechouart, gareDuNord, 2, false);
        Voie gareDuNord_gareDeLEstVerdun = new Voie(gareDuNord, gareDeLEstVerdun, 2, false);
        Voie gareDeLEstVerdun_chateauDEau = new Voie(gareDeLEstVerdun, chateauDEau, 1, false);
        Voie chateauDEau_strasbourgSaintDenis = new Voie(chateauDEau, strasbourgSaintDenis, 1, false);
        Voie strasbourgSaintDenis_reaumurSebastopol = new Voie(strasbourgSaintDenis,reaumurSebastopol, 1, false);
        Voie reaumurSebastopol_etienneMarcel = new Voie(reaumurSebastopol, etienneMarcel, 2, false);
        Voie etienneMarcel_lesHalles = new Voie(etienneMarcel, lesHalles, 1, false);
        Voie lesHalles_chatelet = new Voie(lesHalles, chatelet, 1,false);
        Voie chatelet_cite = new Voie(chatelet, cite, 2, false);
        Voie cite_saintMichel = new Voie(cite, saintMichel, 1, false);
        Voie saintMichel_odeon = new Voie(saintMichel, odeon, 1, false);
        Voie odeon_saintGermainDesPres = new Voie(odeon, saintGermainDesPres, 1, false);
        Voie saintGermainDesPres_saintSulpice = new Voie(saintGermainDesPres, saintSulpice, 1, false);
        Voie saintSulpice_saintPlacide = new Voie(saintSulpice, saintPlacide, 1, false);
        Voie saintPlacide_montparnasseBienvenue = new Voie(saintPlacide, montparnasseBienvenue, 2, false);
        Voie montparnasseBienvenue_vavin = new Voie(montparnasseBienvenue, vavin, 1, false);
        Voie vavin_raspail = new Voie(vavin, raspail, 1, false);
        Voie raspail_denfertRochereau = new Voie(raspail, denfertRochereau, 2, false);
        Voie denfertRochereau_moutonDuvernet = new Voie(denfertRochereau, moutonDuvernet, 1, false);
        Voie moutonDuvernet_alesia = new Voie(moutonDuvernet, alesia, 1, false);
        Voie alesia_porteDOrleansLeclerc = new Voie(alesia, porteDOrleansLeclerc, 1, false);
        Voie porteDOrleansLeclerc_mairieDeMontrouge = new Voie(porteDOrleansLeclerc, mairieDeMontrouge, 2, false);

        List<Voie> voiesLigne4 = new ArrayList<Voie>();
        
        voiesLigne4.add(porteDeClignancourt_simplon);
        voiesLigne4.add(simplon_marcadetPoissonniers);
        voiesLigne4.add(marcadetPoissonniers_chateauRouge);
        voiesLigne4.add(chateauRouge_barbesRochechouart);
        voiesLigne4.add(barbesRochechouart_gareDuNord);
        voiesLigne4.add(gareDuNord_gareDeLEstVerdun);
        voiesLigne4.add(gareDeLEstVerdun_chateauDEau);
        voiesLigne4.add(chateauDEau_strasbourgSaintDenis);
        voiesLigne4.add(strasbourgSaintDenis_reaumurSebastopol);
        voiesLigne4.add(reaumurSebastopol_etienneMarcel);
        voiesLigne4.add(etienneMarcel_lesHalles);
        voiesLigne4.add(lesHalles_chatelet);
        voiesLigne4.add(chatelet_cite);
        voiesLigne4.add(cite_saintMichel);
        voiesLigne4.add(saintMichel_odeon);
        voiesLigne4.add(odeon_saintGermainDesPres);
        voiesLigne4.add(saintGermainDesPres_saintSulpice);
        voiesLigne4.add(saintSulpice_saintPlacide);
        voiesLigne4.add(saintPlacide_montparnasseBienvenue);
        voiesLigne4.add(montparnasseBienvenue_vavin);
        voiesLigne4.add(vavin_raspail);
        voiesLigne4.add(raspail_denfertRochereau);
        voiesLigne4.add(denfertRochereau_moutonDuvernet);
        voiesLigne4.add(moutonDuvernet_alesia);
        voiesLigne4.add(alesia_porteDOrleansLeclerc);
        voiesLigne4.add(porteDOrleansLeclerc_mairieDeMontrouge);
        
        Ligne ligne4 = new Ligne("ligne 4", voiesLigne4);
        
        //Ligne 7
        Station courneuve8Mai1945 = new Station("La Courneuve — 8 Mai 1945", 1, false);
        Station fortdaubervilliers = new Station("Fort d'Aubervilliers", 1, false);
        Station aubervilliersPantinQuatreChemins = new Station("Aubervilliers — Pantin — Quatre Chemins", 1, false);
        Station porteDeLaVillette = new Station("Porte de la Villette (Cité des Sciences et de l'Industrie)", 1, false);
        Station corentinCariou = new Station("Corentin Cariou", 1, false);
        Station crimee = new Station("Crimée", 1, false);
        Station riquet = new Station("Riquet", 1, false);
        //stalingrad 
        Station louisBlanc = new Station("Louis Blanc", 1, false);
        Station chateauLandon = new Station("Château-Landon", 1, false);
        //gareDeLEstVerdun 
        Station poissonniere = new Station("Poissonnière", 1, false);
        Station cadet = new Station("Cadet", 1, false);
        Station lePeletier = new Station("Le Peletier", 1, false);
        Station chausseeDAntinLaFayette = new Station("Chaussée d'Antin — La Fayette", 1, false);
        //opera 
        Station pyramides = new Station("Pyramides", 1, false);
        Station palaisRoyalMuseeLouvre = new Station("Palais Royal — Musée du Louvre", 1, false);
        Station pontNeuf = new Station("Pont Neuf", 1, false);
        //chatelet
        Station pontMarie = new Station("Pont Marie (Cité des Arts)", 1, false);
        Station sullyMorland = new Station("Sully — Morland", 1, false);
        Station jussieu = new Station("Jussieu", 1, false);
        Station placeMonge = new Station("Place Monge (Jardin des Plantes - Arènes de Lutèce)", 1, false);
        Station censierDaubenton = new Station("Censier — Daubenton", 1, false);
        Station lesGobelins = new Station("Les Gobelins", 1, false);
        Station placeDItalie = new Station("Place d'Italie", 1, false);
        Station tolbiac = new Station("Tolbiac", 1, false);
        Station maisonBlanche = new Station("Maison Blanche", 1, false);

        //Les voies de la ligne 7 
        Voie courneuve8Mai1945_fortdaubervilliers = new Voie(courneuve8Mai1945, aubervilliersPantinQuatreChemins, 2, false);
        Voie fortdaubervilliers_aubervilliersPantinQuatreChemins = new Voie(fortdaubervilliers, aubervilliersPantinQuatreChemins,2, false);
        Voie aubervilliersPantinQuatreChemins_porteDeLaVillette = new Voie(aubervilliersPantinQuatreChemins, porteDeLaVillette, 2, false);
        Voie porteDeLaVillette_corentinCariou = new Voie(porteDeLaVillette, corentinCariou, 2, false);
        Voie corentinCariou_crimee = new Voie(corentinCariou, crimee, 1, false);
        Voie crimee_riquet = new Voie(crimee, riquet, 1, false);
        Voie riquet_stalingrad = new Voie(riquet, stalingrad, 1, false);
        Voie stalingrad_louisBlanc = new Voie(stalingrad, louisBlanc, 2, false);
        Voie louisBlanc_chateauLandon = new Voie(louisBlanc, chateauLandon, 1, false);
        Voie chateauLandon_gareDeLEstVerdun = new Voie(chateauLandon, gareDeLEstVerdun, 2, false);
        Voie gareDeLEstVerdun_poissonniere = new Voie(gareDeLEstVerdun, poissonniere, 2, false);
        Voie poissonniere_cadet = new Voie(poissonniere, cadet, 1, false);
        Voie cadet_lePeletier = new Voie(cadet, lePeletier, 1, false);
        Voie lePeletier_chausseeDAntinLaFayette = new Voie(lePeletier, chausseeDAntinLaFayette, 1, false);
        Voie chausseeDAntinLaFayette_opera = new Voie(chausseeDAntinLaFayette, opera, 2, false);
        Voie opera_pyramides = new Voie(opera, pyramides, 1, false);
        Voie pyramides_palaisRoyalMuseeLouvre = new Voie(pyramides, palaisRoyalMuseeLouvre, 2, false);
        Voie palaisRoyalMuseeLouvre_pontNeuf = new Voie(palaisRoyalMuseeLouvre, pontNeuf, 1, false);
        Voie pontNeuf_chatelet = new Voie(pontNeuf, chatelet, 2, false);
        Voie chatelet_pontMarie = new Voie(chatelet, pontMarie, 1, false);
        Voie pontMarie_sullyMorland = new Voie(pontMarie, sullyMorland, 2, false);
        Voie sullyMorland_jussieu = new Voie(sullyMorland, jussieu, 1, false);
        Voie jussieu_placeMonge = new Voie(jussieu, placeMonge, 2, false);
        Voie placeMonge_censierDaubenton = new Voie(placeMonge, censierDaubenton, 1, false);
        Voie censierDaubenton_lesGobelins = new Voie(censierDaubenton,lesGobelins, 1,false);
        Voie lesGobelins_placeDItalie = new Voie(lesGobelins ,placeDItalie, 2,false);
        Voie placeDItalie_tolbiac = new Voie(placeDItalie,tolbiac, 1, false);
        Voie tolbiac_maisonBlanche = new Voie(tolbiac,maisonBlanche, 1, false);
        
        List<Voie> voiesLigne7 = new ArrayList<Voie>();
        
        voiesLigne7.add(courneuve8Mai1945_fortdaubervilliers);
        voiesLigne7.add(fortdaubervilliers_aubervilliersPantinQuatreChemins);
        voiesLigne7.add(aubervilliersPantinQuatreChemins_porteDeLaVillette);
        voiesLigne7.add(porteDeLaVillette_corentinCariou);
        voiesLigne7.add(corentinCariou_crimee);
        voiesLigne7.add(crimee_riquet);
        voiesLigne7.add(riquet_stalingrad);
        voiesLigne7.add(stalingrad_louisBlanc);
        voiesLigne7.add(louisBlanc_chateauLandon);
        voiesLigne7.add(chateauLandon_gareDeLEstVerdun);
        voiesLigne7.add(gareDeLEstVerdun_poissonniere);
        voiesLigne7.add(poissonniere_cadet);
        voiesLigne7.add(cadet_lePeletier);
        voiesLigne7.add(lePeletier_chausseeDAntinLaFayette);
        voiesLigne7.add(chausseeDAntinLaFayette_opera);
        voiesLigne7.add(opera_pyramides);
        voiesLigne7.add(pyramides_palaisRoyalMuseeLouvre);
        voiesLigne7.add(palaisRoyalMuseeLouvre_pontNeuf);
        voiesLigne7.add(pontNeuf_chatelet);
        voiesLigne7.add(chatelet_pontMarie);
        voiesLigne7.add(pontMarie_sullyMorland);
        voiesLigne7.add(sullyMorland_jussieu);
        voiesLigne7.add(jussieu_placeMonge);
        voiesLigne7.add(placeMonge_censierDaubenton);
        voiesLigne7.add(censierDaubenton_lesGobelins);
        voiesLigne7.add(lesGobelins_placeDItalie);
        voiesLigne7.add(placeDItalie_tolbiac);
        voiesLigne7.add(tolbiac_maisonBlanche);

        Ligne ligne7 = new Ligne("ligne 7", voiesLigne7);
        
        
        
    }
    
    
    
    
}

