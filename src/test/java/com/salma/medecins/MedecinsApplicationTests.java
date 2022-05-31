package com.salma.medecins;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.salma.medecins.entities.Medecin;
import com.salma.medecins.entities.Servicem;
import com.salma.medecins.repos.MedecinRepository;
@SpringBootTest
class medecinsApplicationTests {
@Autowired
private MedecinRepository medecinRepository;
@Test
public void testCreateMedecin() {
Medecin med = new Medecin("nejib","généraliste",new Date());
medecinRepository.save(med);
}
@Test
public void testFindMedecin()
{
Medecin m = medecinRepository.findById(1L).get();

System.out.println(m);
}
@Test
public void testUpdateMedecin()
{
Medecin m = medecinRepository.findById(1L).get();
m.setSpecialiteMedecin("généraliste");
medecinRepository.save(m);
}
@Test
public void testDeletemedecin()
{
medecinRepository.deleteById(1L);
}
@Test
public void testListerTousmedecins()
{
List<Medecin> meds = medecinRepository.findAll();
for (Medecin m : meds)
{
System.out.println(m);
}

}
@Test
public void testFindByNomMedecin()
{
List<Medecin> meds = medecinRepository.findByNomMedecin("slim");

for (Medecin m : meds)
{
System.out.println(m);
}

}
@Test
public void testFindByNomMedecinContains ()
{
List<Medecin> meds=medecinRepository.findByNomMedecinContains("slim");

for (Medecin m : meds)
{
System.out.println(m);
} }
@Test
public void testfindByNomSpecialite()
{
List<Medecin> meds = medecinRepository.findByNomSpecialite("slim", "dermato");
for (Medecin m : meds)
{
System.out.println(m);
}

}
@Test
public void testfindByServicem()
{
Servicem ser = new Servicem();
ser.setIdSer(1L);
List<Medecin> meds = medecinRepository.findByServicem(ser);
for (Medecin m : meds)
{
System.out.println(m);
}
}
@Test
public void findByServicemIdSer()
{
List<Medecin> meds = medecinRepository.findByServicemIdSer(1L);
for (Medecin m : meds)
{
System.out.println(m);
}

}
@Test
public void testfindByOrderByNomMedecinAsc()
{
List<Medecin> meds =

medecinRepository.findByOrderByNomMedecinAsc();
for (Medecin m : meds)
{
System.out.println(m);
}

}

}
