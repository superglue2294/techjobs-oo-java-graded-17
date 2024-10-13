package org.launchcode.techjobs.oo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    Job job;

    @Before
    public void createJobObject() {
        job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job.getName() instanceof String);
        assertEquals(job.getName(), "Product tester");

        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals(job.getEmployer().getValue(), "ACME");

        assertTrue(job.getLocation() instanceof Location);
        assertEquals(job.getLocation().getValue(), "Desert");

        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals(job.getPositionType().getValue(), "Quality control");

        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.toString().startsWith(System.lineSeparator()));
        assertTrue(job.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        assertTrue(job.toString().contains("ID: "));
        assertEquals(job.getId(), 8, 0.001);

        assertTrue(job.toString().contains("Name: "));
        assertTrue(job.toString().contains(job.getName()));

        assertTrue(job.toString().contains("Employer: "));
        assertTrue(job.toString().contains(job.getEmployer().getValue()));

        assertTrue(job.toString().contains("Location: "));
        assertTrue(job.toString().contains(job.getLocation().getValue()));

        assertTrue(job.toString().contains("Position Type: "));
        assertTrue(job.toString().contains(job.getPositionType().getValue()));

        assertTrue(job.toString().contains("Core Competency: "));
        assertTrue(job.toString().contains(job.getCoreCompetency().getValue()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));

        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");

        assertTrue(job.toString().contains("Data not available"));
    }

    @Test
    public void testToStringOnlyContainsId() {
        Job job = new Job();

        assertTrue(job.toString().contains("OOPS! This job does not seem to exist."));
    }
}
