package com.bcp.backend.configuration.utils;

public class Constants {
    public static final String SECRET = "SecretKey";
    public static final Long[] succursaleCodeData = {
            628L, 608L, 620L, 622L, 17623L,
            17635L, 634L, 629L, 621L, 920L,
            81626L, 623L, 655L, 624L, 626L,
            627L, 630L, 625L, 655L, 655L
    };
    public static final Long[] BprCodeData = {
            27L, 45L, 50L, 17L, 1L,
            48L, 57L, 64L, 81L, 78L,
            90L, 30L, 43L, 99L
    };

    public static final String[] bprName = {
            "BANQUE POPULAIRE D AGADIR",
            "BANQUE POPULAIRE D EL JADIDA",
            "BANQUE POPULAIRE DE FES",
            "BANQUE POPULAIRE DE LAAYOUNE",
            "BANQUE POPULAIRE DE MARRAKECH",
            "BANQUE POPULAIRE DE MEKNES",
            "BANQUE POPULAIRE DE NADOR",
            "BANQUE POPULAIRE D OUJDA",
            "BANQUE POPULAIRE TANGER-TETOUAN",
            "BANQUE POPULAIRE DE CASABLANCA",
            "BANQUE POPULAIRE DE RABAT",
            "BANQUE CENTRALE POPULAIRE",
            "CREDIT POPULAIRE DU MAROC",
            "CASA SUD ATTAWFIK"
    };

    public static final String[] barAddress = {
            "AVENUE HASSAN II B.P. 246",
            "7, AVENUE DE LA LIGUE ARABE",
            "ANGLE RUE ALLAL LOUDYI & ABDELALI BENCHEKROUN B.P.276",
            "9, BD. MOHAMED V B.P.82",
            "AVENUE ABDELKRIM KHATTABI B.P.968",
            "4, RUE D'ALEXANDRIE",
            "113, BD. ALMASSIRA BP 86",
            "34, BD. DERFOUFI B.P.440",
            "76, BD. MOHAMMED V B.P.313",
            "2 AVENUE MOULAY RACHID ESPACE PORTE D ANFA",
            "3 AVENUE TRABLESS B.P.6",
            "101 BD ZERKTOUNI",
            "101 BD ZERKTOUNI",
            "79 BOULEVARD HASSAN 2"
    };
    public static final Long[] agencyCode = {114L, 181L, 160L, 161L, 456L, 312L, 543L, 789L, 234L, 675L, 879L, 543L};
    public static final String[] agencyName = {
            "IBN-ZOHR",
            "TNINE LAGHYAT",
            "SEBT GZOULA",
            "JEMAA SHAIM",
            "AHFIR",
            "TIZNIT",
            "TAFRAOUTE",
            "IMOUZZER KANDAR",
            "AIT YAAZEM",
            "AIT OURIR",
            "AIT MELLOUL",
            "AIT BAHA",
            "AFOURAR",
            "AKKA",
            "AZILAL",
            "BEN AHMED",
            "BEN SLIMANE",
            "BERKANE",
            "BOUARFA",
            "BOUJDOUR",
            "BOUKNADEL",
            "BOULEMANE",
            "BOUZNIKA"
    };

    public static final String[] agencyAddress = {
            "Avenue Med EL FASSI, IMM N° 515 AG BP HAY SALAM",
            "TNINE LAGHYAT",
            "SEBT GZOULA",
            "JEMAA SHAIM",
            "Sidi Yacoub",
            "Douar Tizguine",
            "Douar El Hadj Brahim",
            "Douar Oulad Ben Chiker",
            "Hay Oulad Sidi Ali",
            "Douar Oulad Jilali",
            "Sidi Allal Tazi",
            "Hay Lalla Meriem",
            "Hay El Massira",
            "Hay Oulad Hriz",
            "El Khairia",
            "Hay El Amal",
            "Quartier Industriel",
            "Rue Hassan II",
            "Rue Mohammed V",
            "Avenue Mohammed VI"
    };

    public static final String[] applicationName = {
            "impayes salaf et evolan",
            "appltest",
            "application",
            "transfert",
            "prés compte sur salaire",
            "moyen de paiement",
            "demande chequier",
            "itf app",
            "etats hbm ancienne convention bcp-c ih",
            "evolan garantie",
            "rapprochement",
            "masterpiece: gestion des immobilisations",
            "application vignette voiture",
            "application mns",
            "automatisation des mt103",
            "appli bladi express",
            "banque al maghreb application",
            "integration automatique des factures des fournisseurs majeurs"
    };
    public static final String[] applicationCode = {
            "EGR", "RAP", "MADM", "CVA", "DSM", "TBM", "VBH", "CDG", "PPR-EVOLAN", "FIAB",
            "PTF", "SOC", "FA", "PVG", "MNS", "CNQ", "BCDM", "BAM", "IAFFM"
    };
    public static final String[]  stateName = {
            "Maroc Leasing",
            "ETAT MENSUELS DES TRANSACTIONS MNS2 CSD",
            "ETAT MENSUELS DES TRANSACTIONS MNS2 CRD",
            "IMPAYE EVOLAN",
            "IMPAYE SALAF",
            "TEST",
            "Etat des écritures comptables devise BP-entreprise",
            "Etat des virements reçus BP-entreprise",
            "Etat des écritures comptables devise Adria",
            "BALANCE",
            "SUSPENS",
            "Etat des opérations MT103 valides automatiquement",
            "Etat des opérations MT103 DEVISE",
            "Etat des opérations MT103 Rejetées",
            "Etat des opérations MT103 entreprises",
            "Etat des opérations MT103 portant une référence dupliquée au niveau de la table MCS",
            "Etat des opérations MT103 portant une référence dupliquée reçue",
            "Etat des opérations MT103 portant une référence dupliquée au niveau de la table RDV",
            "Fraudes sur chèques",
            "Etat des references PORTNET erronnées et en doubles",
            "Virement RTGS des fonds collectés pour DGI",
            "Compte rendu déclaration fraudes chèques",
            "Compte Rendu déclaration fraudes su chèques",
            "Rapport Vectis",
            "Restitution aux clients des montants des vignettes prélevées à tort",
            "ETATS DES CONFIRMATIONS (EVOLAN)",
            "ETATS DES CONFIRMATIONS DE REJET(EVOLAN)",
            "ETATS DE REJETS DE CONSULTATION(EVOLAN)",
            "EDITION DES ETATS DES DOSSIERS A QUOTITE INSUFISANTE(EVOLAN)",
            "ETATS DES REJETS DE CONSULTATION",
            "Etat des opérations négociées",
            "Etats des opérations non négociées",
            "Brouillard destiné à la fonction destinatrice",
            "Brouillard destiné à la fonction initiatrice",
            "Etat de traitement des CRO TI",
            "Etat des rejets CRO TI",
            "ETAT DES ANOMALIES DES COMPTES DE REGROUPEMENT AGIOS",
            "ETAT DES AUTORISATIONS EN COURS",
            "Etat quotidien des dates de valeur préférentielles",
            "Etat des virements valides reçus Adria",
            "ETAT MENSUEL DES DATES DE VALEUR HORS FOURCHETTE PAR AGENCE",
            "VECTIS",
            "Journal Grand Livre",
            "Balance Groupée",
            "Situation Comptable",
            "Etats annulés",
            "Etats réconciliés",
            "Fichier Clients",
            "Fichier Crédits",
            "Personnes physiques",
            "Personnes morales",
            "BALGP",
            "EMVTSBPR",
            "Fermetures Comptes Clients",
            "JGL Clients",
            "Fecmeture Comptes Auxilières",
            "Etat des ouvertures de comptes en devise",
            "Etat des cre devise",
            "Etat Balance devise",
            "Journal grand livre devise",
            "Etat Définitif",
            "Etat des comptes inexistants",
            "Etat des MT103 MRE",
            "Etat des CREs Valide",
            "Etat Achat Vente des devises",
            "Etat des CREs Rejetés",
            "BALANCE GROUPEE DH DEVISE",
            "CR 3 : Scolarité",
            "Rejet CR 3 : Scolarité",
            "CR 17 : revenus investissements étranger",
            "Rejet CR 17 : revenus investissements ét",
            "CORRESPONDANCE DES REFERENCES",
            "ETATS DE SORT DES FICHIERS",
            "ETATS DES VIREMENTS REJETES",
            "ETATS DES VIREMENTS VALIDES",
            "CR 19 : transferts investissements maro",
            "Rejet CR 19: transfert investissement ME",
            "Etat des suspens des comptes en devises",
            "Balance devise complémentaire D",
            "JGL devise complémentaire P",
            "rejet devise complémentaire D",
            "JGL devise complémentaire def",
            "Balance devise complémentaire prov",
            "rejet devise complémentaire PROV",
            "ETAT DES EVENEMENTS DE LA COMP D",
            "ETAT D OUVERTURE DE COMPTES EN DEVISES P",
            "Rejet des DTI",
            "Rejet des DMT",
            "Rejet des UTI",
            "Rejet des DTI",
            "Etat de correspondance des références DM",
            "Etat du répertoire de OCH",
            "Etat Opération CPM",
            "Etat Opération fondation",
            "Etat Mensuel",
            "Etat opération orpheline",
            "Opérations exceptionnel vente à la clien",
            "Opérations exceptionnel vente à la clien",
            "Conditions d'éligibilté FOGALOGE",
            "Conditions d'éligibilté FOGALOGE",
            "Etat des annulations TAM",
            "Etat des demandes de garantie FOGALEF",
            "Etat des remboursements partiel",
            "Rachat des crédits FOGALEF",
            "Conditions d'éligibilité au FOGARIM",
            "Conditions d'éligibilité au FOGARIM",
            "Demande de mise en jeu de la garantie",
            "Commissions/transferts",
            "Commissions/transferts",
            "Commissions/transferts",
            "Brouillard des transferts",
            "Brouillard des transferts",
            "Brouillard des transferts",
            "Etat"
    };
    public static final String[] stateCode = {
            "VBQ", "STC", "CFR", "CQQ", "RVQ", "CDD", "PAA", "PAQ", "CQA", "CVQ", "MEF",
            "EVOLAN-L", "GPD", "CRD", "PBA", "CIN", "DEV", "CQH", "BMH", "CDS", "TRS",
            "MDQ", "CMM", "RME", "GPM", "LETT", "FMM", "BDC", "BFS", "CDM", "CFL",
            "CFM", "CPM", "DKM", "DKT", "MADM", "PAD", "PAM", "PEM", "RRM", "RSM",
            "RXM", "SIM", "TRA", "VBM", "RPQ", "CNQ", "BCDM", "BAM", "IAFFM", "OCH",
            "MDP-L", "DCC", "OCP", "PPR-EVOLAN", "FIAB", "MPNET", "CDH", "ETATJC",
            "MDMCH", "ITF", "PPR", "HBM", "EGR", "RAP", "CVA", "DSM", "TBM", "VBH",
            "SOC", "FA", "PVG"
    };
    public static final String[] code_etat = {
            "MLEASI", "MLEASI", "CSDCSD", "CRDCRD", "IMPEVO", "IMPSLF", "ETATTEST1", "DCEBPE", "ET101BPE", "ETDCEAD", "BAL", "SUS", "M103VLD", "M103DEV", "M103REJ", "M103ENT", "MT103DBM", "M103DBL", "MT103DBR", "FRDCHQ", "DTIPRT", "DGIREPT1",
            "CTRCHQ", "CTRCAR", "VECTIF", "PVGTRX", "PPRQO043", "PPRQO044", "PPRQO025", "PPRQO026", "PPRQO023", "OPNEGO", "OPNNEG", "BRD001", "BRI001", "ETCROTI", "ETCRORJ", "EMACRAG", "EMAUENC", "ETGQDVP", "ET101AD", "EMDVHFA", "VECTIS", "JGL", "BLC", "STC",
            "ANN", "REC", "CLI", "LCC", "CLIP", "CLIM", "LCC", "BALGP", "EMVTSBPR", "FCCCLI", "JGLCLI", "FCCAUX", "ETCPOVD", "ETATCRE", "ETRBALD", "ETRJGLD", "CINDEF", "ETCORESP", "AMSCOM", "AMSFIN", "AMSRES", "AMSCPT", "AMSMRE", "ETCRE", "ETAVD", "ETCRER", "BALGPDV",
            "SCOL10", "REJCR3", "REVLNVM", "REJCR17", "ETATCOR", "ETCRPE", "ETCRPD", "ETCRPV", "TRINVME", "REJCR19", "ETRETA", "DEVBALD", "DEVJGLDP", "DEVREJD", "DEVJGLDD", "DEVBALDP", "DEVREJP", "ETECDCD", "ETOVCPP", "REJDTI", "REJDMT", "REJUTI", "DTIREJ", "ETCORTI",
            "ETREPDOM", "ETACSH", "ETCSHF", "ETCSHM", "ETCSHO", "CNQSYS2", "CNQSYS3", "CNQO03", "CVQO04", "CNQO041", "CNQO042", "CNQO043", "CRDSPOT", "DKQECC1", "DKQECC2", "DKQECC3", "DKQECC4", "DKQECC5", "DKQECC6", "DKQ0021", "DKQ0022", "DKQ0023", "DKQ0024", "DKQ0025", "DKQ0026",
            "MDQO11", "MDQO14", "MDQO15", "MDQO17", "MDQO18", "PEA126", "PEA141", "PNQO071", "PNQO072", "PNQO073", "PNQO08", "PNQO101", "PNQO102", "PNQO103", "PNQO104", "PNQO105", "PNQLBM", "PNQREC", "PNQRECA", "PNQTRF", "RPQO011", "RPQO012", "RPQO013", "RPQO014", "VBQAVBT", "VBQGBP2",
            "VBQGP2", "VBQGR2", "VBQO0031", "VBQO0032", "VBQO0033", "VBQO0034", "VBQO0035", "VBQO0036", "VBQO0037", "VBQO0038", "VBQO0039", "VBQO003X", "VBQO003Y", "VBQO003Z", "VBQO003U", "VBQO005", "VBQO0171", "VBQO0172", "VBQO0173", "VBQO037", "VBQO038", "VBQO041", "VBQO05N", "VBQO058",
            "STCQO101", "STCQO102", "STCQO103", "STCQO02", "STCMET2", "CFRQRAD", "CQQO151", "CQQO152", "RVQO04", "CDDEF", "PAARVNR1", "PAARVNR2", "PAQO66", "PAQFC1", "SRET01", "SRET17", "SRET27", "SRET43", "SRET45", "SRET48", "SRET50", "SRET57", "SRET64", "SRET78", "SRET80", "SRET81", "SRET90",
            "ETRJGL", "ETRBAL", "ETREXTR", "VBQO0051", "VBQO0052", "MEFHO101", "MEFHO102", "MEFHO103", "LSQEDBL", "LSQENDB", "LSQEIMP", "GPDDP1", "GPDDP2", "CRDRSTL", "CRDMMRL", "PBA1L071", "PBA1L072", "CNQO061", "CNQO062", "GPDMTL1", "GPDMTL2", "STCMREC1", "STCMREC2", "STCMREC3", "STCMREC4", "STCTREC1",
            "STCTREC2", "STCTREC3", "STCTREC4", "ETREXTR", "ETRREJ", "CQHO01", "BMHO01", "CDSUIJ1", "CDSUIJ2", "CQQO101", "CQAGRDJ1", "CQAGRDJ2", "WBCDMMV", "WSTQEURO", "WMDQANS", "WMDQYOSF", "WMDQLAR", "WMDQCAX", "WMDQCECA", "WMDQBPEE", "CMMO03", "CMMO20L",
            "RME29", "RME82", "GPMO01", "SRBM", "SUSPENCI",
            "FMMO0011", "FMMO0012", "FMMO0013", "BDC130", "BFSAC", "CDMIAM0", "CDMIAM11", "CDMIAM12", "CDMIAM13", "CDMIAM2", "code_etat\n" +
            "CDMSPO11"};

    public static final String[] profiles = {
            "Responsable BPR",
            "AgentBPR",
            "Contrôleur BPR",
            "Contrôleur BCP",
            "AgentSuccursale",
            "AgentAgence",
    };


}
