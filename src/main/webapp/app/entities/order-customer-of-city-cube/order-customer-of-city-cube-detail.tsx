import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import {} from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './order-customer-of-city-cube.reducer';

export const OrderCustomerOfCityCubeDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const orderCustomerOfCityCubeEntity = useAppSelector(state => state.orderCustomerOfCityCube.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="orderCustomerOfCityCubeDetailsHeading">Order Customer Of City Cube</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="cityName">City Name</span>
          </dt>
          <dd>{orderCustomerOfCityCubeEntity.cityName}</dd>
          <dt>
            <span id="officeAddress">Office Address</span>
          </dt>
          <dd>{orderCustomerOfCityCubeEntity.officeAddress}</dd>
          <dt>
            <span id="orderedQuantity">Ordered Quantity</span>
          </dt>
          <dd>{orderCustomerOfCityCubeEntity.orderedQuantity}</dd>
          <dt>
            <span id="orderedCost">Ordered Cost</span>
          </dt>
          <dd>{orderCustomerOfCityCubeEntity.orderedCost}</dd>
          <dt>
            <span id="profit">Profit</span>
          </dt>
          <dd>{orderCustomerOfCityCubeEntity.profit}</dd>
        </dl>
        <Button tag={Link} to="/order-customer-of-city-cube" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/order-customer-of-city-cube/${orderCustomerOfCityCubeEntity.cityName}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default OrderCustomerOfCityCubeDetail;
