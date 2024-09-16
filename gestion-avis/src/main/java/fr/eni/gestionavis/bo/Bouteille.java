//package fr.eni.gestionavis.bo;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;
//
//import java.time.LocalDate;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Document(collection = "Avis")
//public class Bouteille {
//
//    @Id
//    private String id;
//
//    @Field("note")
//    private int note;
//
//    @Field("commentary")
//    private String commentary;
//
//    @Field("date")
//    private LocalDate date;
//
//}