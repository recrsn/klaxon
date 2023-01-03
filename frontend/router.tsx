import MainLayout from 'Frontend/pages/MainLayout.js';
import { createBrowserRouter } from 'react-router-dom';
import HomePage from 'Frontend/pages/home/HomePage';
import EnvironmentsListView from 'Frontend/pages/environments/EnvironmentsListView';
import AboutPage from 'Frontend/pages/about/AboutPage';
import CreateEnvironmentPage from 'Frontend/pages/environments/CreateEnvironmentPage';
import EnvironmentDetailPage from 'Frontend/pages/environments/EnvironmentDetailPage';
import ServiceListPage from 'Frontend/pages/services/ServiceListPage';
import ServiceDetailPage from 'Frontend/pages/services/ServiceDetailPage';

const router = createBrowserRouter([
  {
    path: '/',
    element: <MainLayout />,
    children: [
      { path: '/', element: <HomePage /> },
      { path: '/environments', element: <EnvironmentsListView /> },
      { path: '/environments/new', element: <CreateEnvironmentPage /> },
      { path: '/environments/:key', element: <EnvironmentDetailPage /> },
      { path: '/services', element: <ServiceListPage /> },
      { path: '/services/:key', element: <ServiceDetailPage /> },
      { path: '/about', element: <AboutPage /> },
    ],
  },
]);
export default router;
