	package vn.iostar.SpringSer.Entity;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name = "Products")
	public class Product {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(columnDefinition = "nvarchar(255)")
	    private String name;

	    @Column(columnDefinition = "nvarchar(255)")
	    private String brand;

	    @Column(columnDefinition = "nvarchar(255)")
	    private String madein;

	    private float price;
	}
