public class  TierHistoryRecord{
    @Id
    private Long id;
    private  String fromTier;
    private String toTier;
    private Double minSpend;
    private Integer minVisits;
    private Boolean active;
}