package de.uni_ulm.sp.oop.sose24.sheet10.exercise1;

import de.uni_ulm.sp.oop.sose24.sheet10.exercise1.models.Clique;
import de.uni_ulm.sp.oop.sose24.sheet10.exercise1.models.Lad;
import de.uni_ulm.sp.oop.sose24.sheet10.exercise1.models.Lass;
import de.uni_ulm.sp.oop.sose24.sheet10.exercise1.models.Person;

public class Main {

    Lad lad = new Lad("Stefan Götz");
    Lass lass = new Lass("Stefanie Götz");

    Person ladpers = lad;
    Person lassPers = lass;
    Clique cliqued = new Clique();
    boolean addlad = cliqued.addMember(ladpers);
    boolean addlass = cliqued.addMember(lassPers);





}
