package nmr.demo.repositories;

import nmr.demo.Models.AutoCamper;

import java.util.List;

public interface IAutoCamperRepository {

        public boolean create();
        public AutoCamper read(int id);
        public List<AutoCamper> readAll();
        public boolean update();
        public boolean delete();


    }

