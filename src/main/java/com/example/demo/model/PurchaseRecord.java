public class PurchaseRecord{
    @Id
    private Long id;
    @Column(unique=true)
    private String customerId;
    private Double amount;
    private LocalDate purchaseDate;
    private  String storeLocation;
}