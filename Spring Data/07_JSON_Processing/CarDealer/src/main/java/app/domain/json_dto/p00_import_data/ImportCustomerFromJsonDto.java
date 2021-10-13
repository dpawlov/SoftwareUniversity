package app.domain.json_dto.p00_import_data;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class ImportCustomerFromJsonDto {

    @Expose
    private String name;

    @Expose
    private Date birthDate;

    @Expose
    private boolean isYoungDriver;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
