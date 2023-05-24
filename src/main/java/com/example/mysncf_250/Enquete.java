package com.example.mysncf_250;

import java.util.HashMap;

public class Enquete {
    private HashMap<String, Candidat> lesCandidats;

    public Enquete() {
        this.lesCandidats = new HashMap<>();
    }

    public void ajouterCandidat(Candidat unCandidat) {
        this.lesCandidats.put(unCandidat.getEmail(), unCandidat);
    }

    public void ajouterReponse(String question, int score, String email) {
        // Le get sert à récupérer l'objet/valeur candidat qui est identifié par l'email
        // puis on récupère la question et le score de ajouterReponse de la classe Candidat
        this.lesCandidats.get(email).ajouterReponse(question, score);
    }

    public float moyenne (String email) {
        return this.lesCandidats.get(email).moyenne();
    }

    public Candidat getCandidat (String email) {
        return this.lesCandidats.get(email);
    }

    public HashMap<String, Candidat> getLesCandidats() {
        return lesCandidats;
    }

    public void setLesCandidats(HashMap<String, Candidat> lesCandidats) {
        this.lesCandidats = lesCandidats;
    }
}
