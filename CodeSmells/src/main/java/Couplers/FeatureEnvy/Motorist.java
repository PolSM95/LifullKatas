package Couplers.FeatureEnvy;

import java.util.Calendar;
import java.util.Date;

public class Motorist {
    private Date dateOfBirth;

    public Motorist(Date dateOfBirth, int pointsOnLicense)
    {
        this.pointsOnLicense = pointsOnLicense;
        this.dateOfBirth = dateOfBirth;
    }

    private int pointsOnLicense;

    public int getAge()
    {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        Calendar dateOfBirthCalendar = Calendar.getInstance();
        dateOfBirthCalendar.setTime(dateOfBirth);
        int ageYr = now.get(Calendar.YEAR) - dateOfBirthCalendar.get(Calendar.YEAR);
        int ageMo = now.get(Calendar.MONTH) - dateOfBirthCalendar.get(Calendar.MONTH);
        return adjustYearsDownIfNegativeMonthDifference(ageYr, ageMo);
    }

    private int adjustYearsDownIfNegativeMonthDifference(int ageYr, int ageMo)
    {
        if (ageMo < 0)
        {
            ageYr--;
        }
        return ageYr;
    }

    public int getPointsOnLicense() {
        return pointsOnLicense;
    }

    public void setPointsOnLicense(int pointsOnLicense) {
        this.pointsOnLicense = pointsOnLicense;
    }
}
