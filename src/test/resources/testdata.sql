DROP TABLE PRICE IF EXISTS;
 
CREATE TABLE PRICE  (
    BRAND_ID VARCHAR(10),  
    PRODUCT_ID VARCHAR(50),
    PRICELIST VARCHAR(10),  
    STARTDATE TIMESTAMP,
    ENDDATE TIMESTAMP,
    PRIORITY SMALLINT,
    PRICE DECIMAL(9,2),
    CURRENCY VARCHAR(10),
    LASTUPDATE TIMESTAMP,
    LASTUPDATEBY VARCHAR(50)
);

INSERT INTO PRICE (BRAND_ID, PRODUCT_ID, PRICELIST, STARTDATE, ENDDATE, PRIORITY, PRICE, CURRENCY) VALUES
	(1, 35455, 1, parsedatetime('2020-06-14-00.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 0, 35.50, 'EUR'),
	(1, 35455, 2, parsedatetime('2020-06-14-15.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-06-14-18.30.00', 'yyyy-MM-dd-hh.mm.ss'), 1, 25.45, 'EUR'),
	(1, 35455, 3, parsedatetime('2020-06-15-00.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-06-15-11.00.00', 'yyyy-MM-dd-hh.mm.ss'), 1, 30.50, 'EUR'),
	(1, 35455, 4, parsedatetime('2020-06-15-16.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 1, 38.95, 'EUR'),
	(2, 35455, 1, parsedatetime('2020-06-15-16.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 1, 90.22, 'EUR'),
	(2, 35455, 2, parsedatetime('2020-06-15-16.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 1, 68.56, 'EUR');
	

