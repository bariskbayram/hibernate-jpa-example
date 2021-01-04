package org.bkb;


import org.bkb.entity.Alien;
import org.bkb.entity.Hometown;
import org.bkb.entity.UFO;
import org.bkb.entity.Wheel;
import org.bkb.service.AlienService;
import org.bkb.service.HometownService;
import org.bkb.service.UFOService;
import org.bkb.service.WheelService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class App {

    public static void main( String[] args ){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = emf.createEntityManager();

        AlienService alienService = new AlienService(entityManager);
        UFOService ufoService = new UFOService(entityManager);
        HometownService hometownService = new HometownService(entityManager);
        WheelService wheelService = new WheelService(entityManager);

        // BKB Alien and his all information
        Alien bkb = new Alien("Baris", "Bayram", "Red", "bariskbayram@gmail.com", "");
        UFO ufoBkb = new UFO("HAL-9000");
        Wheel WUL_bkb = new Wheel("Wheel up left", ufoBkb);
        Wheel WUR_bkb = new Wheel("Wheel up right", ufoBkb);
        Wheel WDL_bkb = new Wheel("Wheel down left", ufoBkb);
        Wheel WDR_bkb = new Wheel("Wheel down right", ufoBkb);
        Hometown htBkb1 = new Hometown("Jupiter", 23L);
        Hometown htBkb2 = new Hometown("Mars", 3L);

        bkb.setUfo(ufoBkb);
        bkb.setHometowns(Arrays.asList(htBkb1, htBkb2));

        htBkb1.setAliens(Arrays.asList(bkb));
        htBkb2.setAliens(Arrays.asList(bkb));

        ufoBkb.setProducedDate(new Date());
        ufoBkb.setWheels(Arrays.asList(WUL_bkb, WUR_bkb, WDL_bkb, WDR_bkb));

        ufoService.insertUFO(ufoBkb);
        wheelService.insertWheel(WDL_bkb);
        wheelService.insertWheel(WDR_bkb);
        wheelService.insertWheel(WUL_bkb);
        wheelService.insertWheel(WUR_bkb);
        hometownService.insertHometown(htBkb1);
        hometownService.insertHometown(htBkb2);
        alienService.insertAlien(bkb);


        Alien a = alienService.getAlienById(1L);
        System.out.println(a.getFirstName() + " " + a.getLastName());

        Alien a2 = alienService.getAlienById(1L);
        System.out.println(a2.getFirstName() + " " + a2.getLastName());

        System.out.println(a.getUfo().getName());

        Hometown h = hometownService.getHometownById(1L);
        System.out.println(h.getName());

        System.out.println(h.getAliens().get(0).getFirstName());

        List<Wheel> wheelList = a.getUfo().getWheels();
        for (Wheel w: wheelList){
            System.out.println(w.getWheelDefinition());
        }

    }
}
