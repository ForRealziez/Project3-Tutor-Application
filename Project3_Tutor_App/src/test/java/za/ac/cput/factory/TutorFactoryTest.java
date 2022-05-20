package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.entity.Tutor;

import static org.junit.jupiter.api.Assertions.*;

class TutorFactoryTest {

    @Test
    void createTutor() {
        Tutor tutor= TutorFactory.createTutor("lihlegazi17","214258041@mycput.ac.za","Lelihle","Gazi","214258041","2022-17-03");
        assertNotNull(tutor);

    }
}