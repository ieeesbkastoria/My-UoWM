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
