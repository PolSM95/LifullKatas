package OOAbusers.SwitchStatements;

import java.util.Calendar;
import java.util.Date;

public class Motorist {
    private Date dateOfBirth;
    private int PointsOnLicense;

    public Motorist(Date dateOfBirth, int pointsOnLicense)
    {
        this.setPointsOnLicense(pointsOnLicense);
        this.dateOfBirth = dateOfBirth;
    }

    private int adjustYearsDownIfNegativeMonthDifference(int ageYr, int ageMo)
    {
        if (ageMo < 0)
        {
            ageYr--;
        }
        return ageYr;
    }

    public int getAge() {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        Calendar dateOfBirthCalendar = Calendar.getInstance();
        dateOfBirthCalendar.setTime(dateOfBirth);
        int ageYr = now.get(Calendar.YEAR) - dateOfBirthCalendar.get(Calendar.YEAR);
        int ageMo = now.get(Calendar.MONTH) - dateOfBirthCalendar.get(Calendar.MONTH);
        return adjustYearsDownIfNegativeMonthDifference(ageYr, ageMo);
    }

    public int getPointsOnLicense() {
        return PointsOnLicense;
    }

    public void setPointsOnLicense(int pointsOnLicense) {
        PointsOnLicense = pointsOnLicense;
    }
}
