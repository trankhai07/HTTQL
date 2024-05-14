export interface IOrderCustomerOfCityCube {
  cityName?: string;
  officeAddress?: string | null;
  orderedQuantity?: number | null;
  orderedCost?: number | null;
  profit?: number | null;
}

export const defaultValue: Readonly<IOrderCustomerOfCityCube> = {};
