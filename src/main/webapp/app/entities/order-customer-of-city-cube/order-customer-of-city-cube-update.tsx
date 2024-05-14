import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IOrderCustomerOfCityCube } from 'app/shared/model/order-customer-of-city-cube.model';
import { getEntity, updateEntity, createEntity, reset } from './order-customer-of-city-cube.reducer';

export const OrderCustomerOfCityCubeUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const orderCustomerOfCityCubeEntity = useAppSelector(state => state.orderCustomerOfCityCube.entity);
  const loading = useAppSelector(state => state.orderCustomerOfCityCube.loading);
  const updating = useAppSelector(state => state.orderCustomerOfCityCube.updating);
  const updateSuccess = useAppSelector(state => state.orderCustomerOfCityCube.updateSuccess);

  const handleClose = () => {
    navigate('/order-customer-of-city-cube' + location.search);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...orderCustomerOfCityCubeEntity,
      ...values,
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          ...orderCustomerOfCityCubeEntity,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="httqlApp.orderCustomerOfCityCube.home.createOrEditLabel" data-cy="OrderCustomerOfCityCubeCreateUpdateHeading">
            Create or edit a Order Customer Of City Cube
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="cityName"
                  required
                  readOnly
                  id="order-customer-of-city-cube-cityName"
                  label="City Name"
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label="Office Address"
                id="order-customer-of-city-cube-officeAddress"
                name="officeAddress"
                data-cy="officeAddress"
                type="text"
              />
              <ValidatedField
                label="Ordered Quantity"
                id="order-customer-of-city-cube-orderedQuantity"
                name="orderedQuantity"
                data-cy="orderedQuantity"
                type="text"
              />
              <ValidatedField
                label="Ordered Cost"
                id="order-customer-of-city-cube-orderedCost"
                name="orderedCost"
                data-cy="orderedCost"
                type="text"
              />
              <ValidatedField label="Profit" id="order-customer-of-city-cube-profit" name="profit" data-cy="profit" type="text" />
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/order-customer-of-city-cube" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">Back</span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp; Save
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default OrderCustomerOfCityCubeUpdate;
