import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate, getSortState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ASC, DESC, ITEMS_PER_PAGE, SORT } from 'app/shared/util/pagination.constants';
import { overridePaginationStateWithQueryParams } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IOrderCustomerOfCityCube } from 'app/shared/model/order-customer-of-city-cube.model';
import { getEntities } from './order-customer-of-city-cube.reducer';

export const OrderCustomerOfCityCube = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const [paginationState, setPaginationState] = useState(
    overridePaginationStateWithQueryParams(getSortState(location, ITEMS_PER_PAGE, 'cityName'), location.search)
  );

  const orderCustomerOfCityCubeList = useAppSelector(state => state.orderCustomerOfCityCube.entities);
  const loading = useAppSelector(state => state.orderCustomerOfCityCube.loading);
  const totalItems = useAppSelector(state => state.orderCustomerOfCityCube.totalItems);

  const getAllEntities = () => {
    dispatch(
      getEntities({
        page: paginationState.activePage - 1,
        size: paginationState.itemsPerPage,
        sort: `${paginationState.sort},${paginationState.order}`,
      })
    );
  };

  const sortEntities = () => {
    getAllEntities();
    const endURL = `?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`;
    if (location.search !== endURL) {
      navigate(`${location.pathname}${endURL}`);
    }
  };

  useEffect(() => {
    sortEntities();
  }, [paginationState.activePage, paginationState.order, paginationState.sort]);

  useEffect(() => {
    const params = new URLSearchParams(location.search);
    const page = params.get('page');
    const sort = params.get(SORT);
    if (page && sort) {
      const sortSplit = sort.split(',');
      setPaginationState({
        ...paginationState,
        activePage: +page,
        sort: sortSplit[0],
        order: sortSplit[1],
      });
    }
  }, [location.search]);

  const sort = p => () => {
    setPaginationState({
      ...paginationState,
      order: paginationState.order === ASC ? DESC : ASC,
      sort: p,
    });
  };

  const handlePagination = currentPage =>
    setPaginationState({
      ...paginationState,
      activePage: currentPage,
    });

  const handleSyncList = () => {
    sortEntities();
  };

  return (
    <div>
      <h2 id="order-customer-of-city-cube-heading" data-cy="OrderCustomerOfCityCubeHeading">
        Order Customer Of City Cubes
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} /> Refresh list
          </Button>
          <Link
            to="/order-customer-of-city-cube/new"
            className="btn btn-primary jh-create-entity"
            id="jh-create-entity"
            data-cy="entityCreateButton"
          >
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new Order Customer Of City Cube
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {orderCustomerOfCityCubeList && orderCustomerOfCityCubeList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('cityName')}>
                  City Name <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('officeAddress')}>
                  Office Address <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('orderedQuantity')}>
                  Ordered Quantity <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('orderedCost')}>
                  Ordered Cost <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('profit')}>
                  Profit <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {orderCustomerOfCityCubeList.map((orderCustomerOfCityCube, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/order-customer-of-city-cube/${orderCustomerOfCityCube.cityName}`} color="link" size="sm">
                      {orderCustomerOfCityCube.cityName}
                    </Button>
                  </td>
                  <td>{orderCustomerOfCityCube.officeAddress}</td>
                  <td>{orderCustomerOfCityCube.orderedQuantity}</td>
                  <td>{orderCustomerOfCityCube.orderedCost}</td>
                  <td>{orderCustomerOfCityCube.profit}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button
                        tag={Link}
                        to={`/order-customer-of-city-cube/${orderCustomerOfCityCube.cityName}`}
                        color="info"
                        size="sm"
                        data-cy="entityDetailsButton"
                      >
                        <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/order-customer-of-city-cube/${orderCustomerOfCityCube.cityName}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="primary"
                        size="sm"
                        data-cy="entityEditButton"
                      >
                        <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/order-customer-of-city-cube/${orderCustomerOfCityCube.cityName}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="danger"
                        size="sm"
                        data-cy="entityDeleteButton"
                      >
                        <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && <div className="alert alert-warning">No Order Customer Of City Cubes found</div>
        )}
      </div>
      {totalItems ? (
        <div className={orderCustomerOfCityCubeList && orderCustomerOfCityCubeList.length > 0 ? '' : 'd-none'}>
          <div className="justify-content-center d-flex">
            <JhiItemCount page={paginationState.activePage} total={totalItems} itemsPerPage={paginationState.itemsPerPage} />
          </div>
          <div className="justify-content-center d-flex">
            <JhiPagination
              activePage={paginationState.activePage}
              onSelect={handlePagination}
              maxButtons={5}
              itemsPerPage={paginationState.itemsPerPage}
              totalItems={totalItems}
            />
          </div>
        </div>
      ) : (
        ''
      )}
    </div>
  );
};

export default OrderCustomerOfCityCube;
