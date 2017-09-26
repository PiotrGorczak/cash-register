# cash-register

Further steps:
- replace itemPriceRegistry with interface in order to introduce repository (e.g. Spring JPA repository)
- extract the methods which operate on Receipt into Service in service layer (add one) 
- in order to achieve accurate sum calculation (in real case) the BigDecimal class should be introduced
- other steps can be designed based on more detailed analysis of the requirements 