package fr.adbonnin.ippdej.uss.service

interface TeleporteurService {

    /**
     * Téléporte un personnel par son nom.
     *
     * @param nom le nom du personnel à téléporter
     * @return true si au moins un personnel a été téléporté, sinon faux
     */
    boolean transporter(String nom)
}