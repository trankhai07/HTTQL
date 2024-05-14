import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import OrderCustomerOfCityCube from './order-customer-of-city-cube';
import OrderCustomerOfCityCubeDetail from './order-customer-of-city-cube-detail';
import OrderCustomerOfCityCubeUpdate from './order-customer-of-city-cube-update';
import OrderCustomerOfCityCubeDeleteDialog from './order-customer-of-city-cube-delete-dialog';

const OrderCustomerOfCityCubeRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<OrderCustomerOfCityCube />} />
    <Route path="new" element={<OrderCustomerOfCityCubeUpdate />} />
    <Route path=":id">
      <Route index element={<OrderCustomerOfCityCubeDetail />} />
      <Route path="edit" element={<OrderCustomerOfCityCubeUpdate />} />
      <Route path="delete" element={<OrderCustomerOfCityCubeDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default OrderCustomerOfCityCubeRoutes;
