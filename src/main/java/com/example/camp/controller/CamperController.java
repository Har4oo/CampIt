    package com.example.camp.controller;

    import com.example.camp.model.Camper;
    import com.example.camp.service.CamperService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/campers") // Base route
    public class CamperController {

        private final CamperService camperService;

        @Autowired
        public CamperController(CamperService camperService) {
            this.camperService = camperService;
        }

        // GET /api/campers
        @GetMapping
        public List<Camper> getAllCampers() {
            return camperService.getCampers();
        }

        // GET /api/campers/{id}
        @GetMapping("/{id}")
        public Camper getCamperById(@PathVariable Long id) {
            return camperService.getCamper(id);
        }

        // POST /api/campers
        @PostMapping
        public Camper createCamper(@RequestBody Camper camper) {
            return camperService.createCamper(camper);
        }

        // PUT /api/campers/{id}
        @PutMapping("/{id}")
        public Camper updateCamper(@RequestBody Camper camper, @PathVariable Long id) {
            return camperService.updateCamper(camper, id);
        }

        // DELETE /api/campers/{id}
        @DeleteMapping("/{id}")
        public void deleteCamper(@PathVariable Long id) {
            camperService.deleteCamper(id);
        }
    }
