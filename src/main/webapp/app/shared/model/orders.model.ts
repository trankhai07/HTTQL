import dayjs from 'dayjs';

export interface IOrders {
  orderId?: string;
  orderDate?: string | null;
  customerId?: string | null;
}

export const defaultValue: Readonly<IOrders> = {};
