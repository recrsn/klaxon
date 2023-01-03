import { useServices } from 'Frontend/hooks/services';
import { Link } from 'react-router-dom';

export default function ServiceListPage() {
  const { data, isLoading } = useServices();

  return (
    <>
      <h1>Services</h1>
      {isLoading && <p>Loading...</p>}
      {data && (
        <ul>
          {data.map((service) => (
            <li key={service.id}>
              <Link to={`/services/${service.key}`}>{service.name || service.key}</Link>
            </li>
          ))}
        </ul>
      )}
    </>
  );
}
