import i18n from "i18next";
import { initReactI18next } from "react-i18next";
import enRestaurant from "./assets/locales/en/restaurant.js";
import enFreshmen from "./assets/locales/en/freshmen.js";
import enLibrary from "./assets/locales/en/library.js";
import enMaps from "./assets/locales/en/maps.js";
import enServices from "./assets/locales/en/services.js";
import enAcademicPersonel from "./assets/locales/en/academic_personel.js";
import enFaq from "./assets/locales/en/faq.js";
import enProjectMembers from "./assets/locales/en/project_members.js";
import enSettingsPage from "./assets/locales/en/settings_page.js";
import enAboutPage from "./assets/locales/en/about_page.js";
import enError404 from "./assets/locales/en/error404.js"

import elRestaurant from "./assets/locales/el/restaurant.js";
import elFreshmen from "./assets/locales/el/freshmen.js";
import elLibrary from "./assets/locales/el/library.js";
import elMaps from "./assets/locales/el/maps.js";
import elServices from "./assets/locales/el/services.js";
import elAcademicPersonel from "./assets/locales/el/academic_personel.js";
import elFaq from "./assets/locales/el/faq.js";
import elProjectMembers from "./assets/locales/el/project_members.js";
import elSettingsPage from "./assets/locales/el/settings_page.js";
import elAboutPage from "./assets/locales/el/about_page.js";
import elError404 from "./assets/locales/el/error404.js"
import studentCare from "./assets/locales/el/studentCare.js";
import services from "./assets/locales/en/services.js";
import restaurant from "./assets/locales/en/restaurant.js";

const resources = {
  en: {
    translation: {
      ...enRestaurant,
      ...enFreshmen,
      ...enLibrary,
      ...enMaps,
      ...enServices,
      ...enAcademicPersonel,
      ...enFaq,
      ...enProjectMembers,
      ...enSettingsPage,
      ...enAboutPage,
      ...enError404,
      ...studentCare,
      //categories.js
      current_department: "Current Department: ",
      close: "Close",
      eudoxus: "Eudoxus",
      initial_page: "Home",
      course_schedule: "Course Schedules",
      restaurant: "Restaurant",
      library: "Library",
      exams_schedule: "Exams Schedule",
      academic_personnel: "Academic Personnel",
      map: "Maps",
      other_services: "Other Services",
      announcements: "Announcements",
      orkomosies: "Graduation",
      foititiki_merimna: "Student Care",
      freshmen_guides: "Freshmen",
      faq_title: "Frequently Asked",
      faq_subtitle: "You will find answers that might be of interest to you.",
      masters: "Masters",
      error_title: "No Department selected",
      error_description: "Please select Department from Settings",
      graduation_redirection_message:"Redirecting to section",
      graduation_description:"Please select Department from Settings",
      on_weekend:"On Weekend",
      restaurantPage: "Menu Anouncement & Proggram",
       // Student Care
       StudentCare: "Salasidou Despina, Phone: 2467440003, E-mail: dsalasidou@uowm.gr, merimna-kas@uowm.gr",
       StudentCare2: "Sotiropoulou Paraskevi, Phone: 2467440002, E-mail: cs04219@uowm.gr",
      FoititikhMerimna: "Student Welfare",
      Myfeo: "Counselling and Psychological Support Unit MYFEO",
      OlistikhMerimna: "Holistic Care",
      MedicalCare: "Medical care",
      Sitish: "Student Dining",
      Stegash: "Housing",
      FoithtikoEpidoma: "Student Housing Benefit",
      EuroCardAsfalish: "European insurance card",
      online_services: "Online Services",

       // online services
      emaill: "Email",
      vpn: "VPN Service",
      wifi: "Wireless Access",
      software: "Free Software",
      gsuite: "G Suite for education",
      delos365: "Office 365", 
      azure: "Microsoft Azure Dev Tools",

      //services & offices
      Liaison_office: "Liaison Office",
      practice_office:  "Practice Office",
      graduate_office: "Graduate Network",
      erasmus_office: "Erasmus Office",
      Student_Advocate: "Student Advocate",
      Academic_Advisor: "Academic Advisor",
      Complaints_Management: "Complaints Management",

      //Clubs
      IEEEStydentBranch: "IEEE Student Branch",
      ErasmusStudentClub: "Erasmus Student Club",
      KastoriaLinuxSociaty: "Kastoria Linux Society",
      SyllogosPontiwnKastorias: "Pontian Association of Kastoria",
      SyllogosKritikwnKastorias: "Cretan Association of Kastoria",
      DMCTeam: "DMC Team",
      MousikhOmada: "Music Team",
      TheatrikhOmada: "Theatre Team",
      },
  },
  el: {
    translation: {
      ...elRestaurant,
      ...elFreshmen,
      ...elLibrary,
      ...elMaps,
      ...elServices,
      ...elAcademicPersonel,
      ...elFaq,
      ...elProjectMembers,
      ...elSettingsPage,
      ...elAboutPage,
      ...elError404,
      ...studentCare,

      //categories.js
      current_department: "Έχεις επιλέξει: ",
      close: "Κλείσιμο",
      eudoxus: "Εύδοξος",
      initial_page: "Αρχική",
      course_schedule: "Πρόγραμμα Μαθημάτων",
      restaurant: "Εστιατόριο",
      library: "Βιβλιοθήκη",
      exams_schedule: "Πρόγραμμα Εξετάσεων",
      academic_personnel: "Ακαδημαϊκό Προσωπικό",
      map: "Χάρτης",
      other_services: "Υπόλοιπες Υπηρεσίες",
      announcements: "Ανακοινώσεις",
      orkomosies: "Ορκομωσίες",
      foititiki_merimna: "Φοιτητική Μέριμνα",
      freshmen_guides: "Πρωτοετείς",
      faq_title: "Συχνές Ερωτήσεις",
      faq_subtitle: "Εδώ θα βρείτε απαντήσεις σε ερωτήσεις που ενδέχεται να σας ενδιαφέρουν.",
      masters: "Μεταπτυχιακά",
      error_title: "Δεν έχει επιλεγεί τμήμα",
      error_description: "Παρακαλώ επιλέξτε τμήμα από τις ρυθμίσεις",
      graduation_redirection_message:"Ανακατεύθυνση στο τμήμα",
      graduation_description:"Παρακαλώ επιλέξτε τμήμα από τις ρυθμίσεις.",
      on_weekend:"Σάββατο - Κυριακή",
      restaurantPage: "Ανακοίνωση Μενού & Πρόγραμμα",
// Student Care
      StudentCare: "Σαλασίδου Δέσποινα, Τηλέφωνο: 2467440003, E-mail: dsalasidou@uowm.gr, merimna-kas@uowm.gr",
      StudentCare2: "Σωτηροπούλου Παρασκευή, Τηλέφωνο: 2467440002, E-mail: cs04219@uowm.gr",
    FoititikhMerimna: "Φοιτητική Μέριμνα",
    Myfeo: "Μονάδα Συμβουλευτικής και Ψυχολογικής Υποστήριξης ΜΥΦΕΟ",
    OlistikhMerimna: "Ολιστική Μέριμνα",
    MedicalCare: "Ιατροφαρμακευτική Περίθαλψη",
    Sitish: "Σίτιση",
    Stegash: "Στέγαση",
    FoithtikoEpidoma: "Φοιτητικό Στεγαστικό Επίδομα",
    EuroCardAsfalish: "Ευρωπαική κάρτα ασφάλισης",
    online_services: "Hλεκτρονικές Υπηρεσίες", 

    // online services
    emaill: "Ηλεκτρονικό Ταχυδρομείο",
    vpn: "Υπηρεσία VPN",
    wifi: "Ασύρματη Πρόσβαση",
    software: "Δωρεάν Λογισμικό",
    gsuite: "G Suite for education",
    delos365: "Office 365", 
    azure: "Microsoft Azure Dev Tools",

    //Υπηρεσίες & Γραφεία
    Liaison_office: "Γραφείο Διασύνδεσης",
    practice_office: "Γραφείο Πρακτικής Άσκησης",
    graduate_office: "Δίκτυο Αποφοίτων",
    erasmus_office: "Γραφείο Erasmus",
    Student_Advocate: "Συνήγορος του Φοιτητή",
    Academic_Advisor: "Ακαδημαϊκός Σύμβουλος",
    Complaints_Management: "Διαχείριση Παραπόνων",

    //Σύλλογοι
    IEEEStydentBranch: "Φοιτητικό Παράρτημα IEEE ",
    ErasmusStudentClub: "Σύλλογος Φοιτητών Erasmus",
    KastoriaLinuxSociaty: "Καστοριά Linux Society",
    SyllogosPontiwnKastorias: "Σύλλογος Ποντίων Καστοριάς",
    SyllogosKritikwnKastorias: "Σύλλογος Κρητικών Καστοριάς",
    DMCTeam: "DMC Team",
    MousikhOmada: "Μουσική Ομάδα",
    TheatrikhOmada: "Θεατρική Ομάδα",
    },
  },
  de: {
    translation: {
      initial_page: "Startseite",
      course_schedule: "Kursplan",
      restaurant: "Restaurant",
      library: "Bibliothek",
      announcements: "Ankündigungen",
      orkomosies: "Einweihungen",
      foititiki_merimna: "Studentenpflege",
    },
  },
};
const defaultLang = localStorage.getItem("preferred_language")
i18n.use(initReactI18next).init({
  // debug: true,
  resources,
  whitelist: ["en", "el"],
  lng: defaultLang,
  fallbackLng: "en",
  interpolation: {
    escapeValue: false,
  },
});

export default i18n;
