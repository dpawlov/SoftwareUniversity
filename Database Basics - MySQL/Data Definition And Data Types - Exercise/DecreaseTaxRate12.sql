/*20.Decrease Tax Rate*/
USE hotel;
UPDATE payments set tax_rate = tax_rate * 0.97;
SELECT tax_rate FROM payments;