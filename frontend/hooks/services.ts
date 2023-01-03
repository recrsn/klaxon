import { useQuery } from '@tanstack/react-query';
import { ServiceEndpoint } from '../generated/endpoints';

export function useServices() {
  const { data, error, isLoading } = useQuery({
    queryKey: ['services'],
    queryFn: () => ServiceEndpoint.list(),
  });
  return { data, error, isLoading };
}

export function useService(key: string) {
  const { data, error, isLoading } = useQuery({
    queryKey: ['services', key],
    queryFn: () => ServiceEndpoint.get(key),
  });
  return { data, error, isLoading };
}
