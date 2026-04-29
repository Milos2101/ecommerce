package projekat.obj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "currency_response")
public class CurrencyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String from;
    private String to;
    private double rate;
    private String date;
    private String source;
    private double value;
    private double convertedValue;

    public CurrencyResponse(double convertedValue, double value, String source, String date, double rate, String to, String from) {
        this.convertedValue = convertedValue;
        this.value = value;
        this.source = source;
        this.date = date;
        this.rate = rate;
        this.to = to;
        this.from = from;
    }


    public CurrencyResponse() {

    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRate() {
        return String.valueOf(rate);
    }

    public void setRate(String rate) {
        this.rate = Double.parseDouble(rate);
    }
    
    public double getRateDouble() {
        return rate;
    }
    
    public void setRateDouble(double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
