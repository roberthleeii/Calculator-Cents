package com.calculatorcents.calculatorcents;


public class CalculatorClass {


    //properties
    public double DisplayNumber;
    public double Number;
    public double NumberSimpleOpp;
    public double NumberEnterRepeat;
    public double N;
    public double I;
    public double PV;
    public double PMT;
    public double FV;
    public double StoreNumber;

    public int DecimalCount;

    public boolean NewNumber;
    public boolean CalculateNextOpp;
    public boolean CalculateNextOppRepeat;
    public boolean EnterRepeat;
    public boolean NextDecimal;
    public boolean CanDecimal;
    public boolean Compute;

    public char Operator;

    public CalculatorClass(){
        Clear();

        // not in the clear()
        StoreNumber = 0;
    }

    public void Clear()
    {
        DisplayNumber = 0;

        Number = 0;
        NumberSimpleOpp = 0;
        NumberEnterRepeat = 0;
        N = 0;
        I = 0;
        PV = 0;
        PMT = 0;
        FV = 0;

        DecimalCount = 0;

        NewNumber = true;
        CalculateNextOpp = false;
        CalculateNextOppRepeat = false;
        EnterRepeat = false;
        NextDecimal = false;
        CanDecimal = true;
        Compute = false;
    }

    /**
     * Used for button press on numeric keys 0-9
     * @param press double value between 0-9
     */
    public void PressNumber(double press) {

        if (NewNumber) {
            DisplayNumber = press;
            Number = press;
            NewNumber = false;
        }

        else {
            if (!NextDecimal) {
                if (Number >= 0)
                    Number = Number * 10 + press;
                else
                    Number = Number * 10 - press;

            } else {
                double dec = press / Math.pow(10, ++DecimalCount);
                if (Number >= 0)
                    Number = Number + dec;
                else
                    Number = Number - dec;

            }
            DisplayNumber = Number;
        }
    }


    public void PressDecimal()
    {
        if (CanDecimal)
        {
            NextDecimal = true;
            NewNumber = false;
        }
    }

    /**
     /// Used to enter desired operation (+,-,*,or/)
     /// </summary>
     /// <param name="opp">Enter operation in char: '+',  '-',  '*',  '/'.</param>
     */
    public void PressOperation(char opp)
    {
        if (!CalculateNextOpp)
        {
            NumberSimpleOpp = Number;
            Number = 0;
            DisplayNumber = 0;
            CalculateNextOpp = true;
            CanDecimal = true;
        }
        else if (!CalculateNextOppRepeat)
        {
            if ( Operator == '+')
                DisplayNumber = NumberSimpleOpp + Number;
            else if (Operator == '-')
                DisplayNumber = NumberSimpleOpp - Number;
            else if (Operator == '*')
                DisplayNumber = NumberSimpleOpp * Number;
            else if (Operator == '/')
                DisplayNumber = NumberSimpleOpp / Number;
            NumberSimpleOpp = DisplayNumber;
            Number = 0;
            CanDecimal = false;
        }

        Operator = opp;

        EnterRepeat = false;
        NewNumber = true;
        NextDecimal = false;
        DecimalCount = 0;
    }

    public void PressEnter()
    {
        switch (Operator)
        {
            case '+' :
            case '-' :
            case '*' :
            case '/' :
                if (!EnterRepeat)
                {
                    NumberEnterRepeat = Number;
                    if (Operator == '+')
                        Number = NumberSimpleOpp + Number;
                    else if (Operator == '-')
                        Number = NumberSimpleOpp - Number;
                    else if (Operator == '*')
                        Number = NumberSimpleOpp * Number;
                    else Number = NumberSimpleOpp / Number;
                }
                else
                {
                    if (Operator == '+')
                        Number = Number + NumberEnterRepeat;
                    else if (Operator == '-')
                        Number = Number - NumberEnterRepeat;
                    else if (Operator == '*')
                        Number = Number * NumberEnterRepeat;
                    else Number = Number / NumberEnterRepeat;
                }
            DisplayNumber = Number;
            break;
        }

        CalculateNextOpp = false;
        CalculateNextOppRepeat = false;
        EnterRepeat = true;
        NewNumber = true;
        NextDecimal = false;
        DecimalCount = 0;
        CanDecimal = false;
    }

    public void PlusMinus()
    {
        Number = -Number;
        DisplayNumber = Number;
    }

    public void Sqrt()
    {

        Number = Math.sqrt(Number);
        DisplayNumber = Number;
        NewNumber = true;
    }

    public void Percent()
    {
        Number = Number *.01;
        DisplayNumber = Number;
        NewNumber = true;


    }


    public void Delete(String displayString)
    {
        if (!NewNumber)
        {

            String num = displayString.replaceAll(".$","");

            if (!num.equals(" "))
            {
                Number = Double.parseDouble(num);
                DisplayNumber = Number;
            }
            else
            {
                Number = 0;
                DisplayNumber = 0;
            }

            //Display();

            if (DecimalCount > 0)
                DecimalCount -= 1;
        }

    }

    /**
     * Enter Financial Term: 'N', 'I', 'V', 'P', 'F',
     * NEEDS FIXING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * @param press button press
     */
    public void PressFinancial(char press)
    {
        if (!Compute)
        {
            switch (press)
            {
                case 'N':
                    N = Number;
                    break;
                case 'I':
                    I = Number / 100;
                    break;
                case 'V':
                    PV = Number;
                    break;
                case 'P':
                    PMT = Number;
                    break;
                case 'F':
                    FV = Number;
                    break;
            }
        }
        /*
        else
        {
            decimal rate = (decimal)I;
            short numberPeriods = (short)N;
            decimal payment = (decimal)PMT;
            decimal futureValue = (decimal)FV;
            decimal presentValue = (decimal)PV;

            try
            {
                switch (press)
                {
                    case 'N':
                        N = (double)Financial.NumberOfPeriods(rate,payment, presentValue, futureValue, DueDate.EndOfPeriod);
                        Number = N;
                        break;
                    case 'I':
                        I = (double)Financial.Rate(numberPeriods, payment, presentValue, futureValue, DueDate.EndOfPeriod, .07M);
                        Number = I;
                        break;
                    case 'V':
                        PV = (double)Financial.PresentValue(rate,numberPeriods,payment,futureValue, DueDate.EndOfPeriod);
                        Number = PV;
                        break;
                    case 'P':
                        PMT = (double)Financial.Payment(rate, numberPeriods, presentValue, futureValue, DueDate.EndOfPeriod);
                        Number = PMT;
                        break;
                    case 'F':
                        FV = (double)Financial.FutureValue(rate, numberPeriods, payment, presentValue, DueDate.EndOfPeriod);
                        Number = FV;
                        break;
                }
            }
            catch (ArgumentException)
            {
                MessageBox.Show("Check your Numbers");
            }
            finally
            {
                Compute = false;
            }
        }
        DisplayNumber = Number;

        // Same as PressEnter()
        CalculateNextOpp = false;
        CalculateNextOppRepeat = false;
        EnterRepeat = true;
        NewNumber = true;
        NextDecimal = false;
        DecimalCount = 0;
        CanDecimal = false;
         */
    }



}